package mk.ukim.finki.mp.crud.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.mp.crud.model.JobPositions;
import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {

	@Autowired
	private UserService userService;


	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody String editPersonalInfo(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname,
			@RequestParam(value = "birthdate", required = false) String birthdate,
			@RequestParam(value = "ssn", required = false) String ssn,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "mail", required = false) String mail,
			@RequestParam(value = "address", required = false) String address, HttpSession session) {
		
		if ((User) session.getAttribute("user") == null) {
			return "Not logged in";
		}
		
		if (!userService.isManager((User) session.getAttribute("user"))) {
			return "Not manager.";
		}
		
		User userToEdit = (User) session.getAttribute("user");
		if (id != null) {
			userToEdit = userService.getUser(Integer.parseInt(id));
		}
		
		if (address != null) {
			userToEdit.setAddress(address);
		}
		if (birthdate != null) {
			DateFormat formatter;
			Date date = null;
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = (Date) formatter.parse(birthdate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			userToEdit.setBirth_date(date);
		}
		if (gender != null) {
			userToEdit.setGender(gender);
		}
		if (mail != null) {
			userToEdit.setMail(mail);
		}
		if (name != null) {
			userToEdit.setName(name);
		}
		if (surname != null) {
			userToEdit.setSurname(surname);
		}
		if (ssn != null) {
			userToEdit.setSsn(Long.parseLong(ssn));
		}
		if (phone != null) {
			userToEdit.setPhone(phone);
		}
		
		userService.editPersonalInfo(userToEdit);
		session.setAttribute("user", userService.getUser(((User) session.getAttribute("user")).getUser_id()));
		
		return userToEdit.getName();
	}
	
	@RequestMapping(value = "/addJob", method = RequestMethod.POST)
	public String editPersonalInfo(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "position", required = true) String position,
			@RequestParam(value = "salary", required = true) String salary, HttpSession session) {
		
		User login = (User) session.getAttribute("user");
		if (login == null || !userService.isManager(login)) {
			return "redirect:/";
		}
		
		JobPositions job = new JobPositions();
		job.setPosition_name(position);
		job.setSalary(Double.parseDouble(salary));
		job.setUser_id(Integer.parseInt(id));
		job.setStarting_date(new Date());
		userService.addJob(job);
		
		session.setAttribute("user", userService.getUser(((User) session.getAttribute("user")).getUser_id()));
		
		return "redirect:details?id=" + id;
	}

	@RequestMapping(value = "/details")
	public ModelAndView employeesPage(@RequestParam(value = "id", required = false) String id, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/");
		}
		
		ModelAndView res = new ModelAndView("details");
		
		res.addObject("logedUser", user);
		
		if (id != null) {
			int u_id = 0;
			try {
				u_id = Integer.parseInt(id);
			} catch (NumberFormatException e) {
				return new ModelAndView("redirect:details");
			}
			User tmp = userService.getUser(u_id);
			if (tmp != null) {
				user = tmp;
			}
		}
		
		res.addObject("autUser", user);
		List<JobPositions> userJobPos = userService
				.getUserJobPositions(user);
//		List<String> jobTitles = new ArrayList<>();
//		List<Double> salaries = new ArrayList<>();
//
//		for (UserJobPosition userJobPosition : userJobPos) {
//			jobTitles.add(0,
//					userService.getPositionName(userJobPosition.getJob_id()));
//			salaries.add(0,
//					userService.getSalary(userJobPosition.getSalary_id()));
//		}
		res.addObject("userJobPositions", userJobPos);
//		res.addObject("jobTitles", jobTitles);
//		res.addObject("salaries", salaries);
		res.addObject("manager", userService.isManager((User) session.getAttribute("user")));

		return res;
	}

}
