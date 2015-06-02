package mk.ukim.finki.mp.crud.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.mp.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mk.ukim.finki.mp.crud.model.*;
@Controller
public class LinkController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/")
	public ModelAndView indexPage(HttpSession session) {
		ModelAndView res=new ModelAndView("login");
		if (session.getAttribute("user") == null)
			return res;
		return new ModelAndView("redirect:details");
	}
	@RequestMapping(value="/news")
	public ModelAndView news(HttpSession session) {
		ModelAndView res=new ModelAndView("news");
		//announcements
		User authenticatedUser=(User) session.getAttribute("user");
		res.addObject("autUser",authenticatedUser); 
		List<Announcements> announcements=userService.getAllAnnouncements();
		System.out.println(announcements);
		res.addObject("announcements",announcements);
		List<String> userNames=new ArrayList<>();
		for(Announcements a : announcements){
			userNames.add(userService.getUserName(a));
		}
		res.addObject("userNames",userNames);
		return res;
	}
	@RequestMapping(value="/list")
	public ModelAndView list() {
		ModelAndView res=new ModelAndView("list");
		//employees view
		List<List<String>> jobs=new ArrayList<List<String>>();
		List<User> employees = userService.getAllUsers();
		for(User user : employees){
			List<UserJobPosition> userJob=userService.getUserJobPositions(user);
			List<String> jobTitle=new ArrayList<>();
			for (UserJobPosition userJobPosition : userJob) {
				jobTitle.add(0,userService.getPositionName(userJobPosition.getJob_id()));
			}
			jobs.add(jobTitle);
		}
		res.addObject("job",jobs);
		res.addObject("numEmployees",employees.size());
		res.addObject("employees", employees);
		return res;
	}
	
	@RequestMapping(value = "/addedAnnouncement", method = RequestMethod.POST)
	public String addedAnn(@RequestParam String title, @RequestParam String announcement,HttpSession session){
		User authenticatedUser=(User) session.getAttribute("user");
		Announcements a=new Announcements();
		a.setAnnouncement(announcement);
		a.setAnnouncement_title(title);
		Date date=new Date();
		a.setDatum(date);
		a.setUser_id(authenticatedUser.getUser_id());
		userService.addAnnouncement(a);
		return "redirect:news";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String editPersonalInfo(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("birthdate") String birthdate, @RequestParam("ssn") String ssn, @RequestParam("gender") String gender, @RequestParam("phone") String phone, @RequestParam("mail") String mail, @RequestParam("address") String address,HttpSession session ) {
		User userToEdit=(User) session.getAttribute("user");
		System.out.println(name+"HAHAHAHAHAHAHAHAHAHAHAH"+surname+" "+gender+" "+mail+" "+address);
		userToEdit.setAddress(address);
		DateFormat formatter;
	    Date date = null;
	    formatter = new SimpleDateFormat("yyyy-MM-dd");
	    try {
			date = (Date) formatter.parse(birthdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userToEdit.setBirth_date(date);
		userToEdit.setGender(gender);
		userToEdit.setMail(mail);
		userToEdit.setName(name);
		userToEdit.setSurname(surname);
		userToEdit.setSsn(Long.parseLong(ssn));
		userToEdit.setPhone(phone);
		userService.editPersonalInfo(userToEdit);
		return "redirect:details";
	}
	
	
	@RequestMapping(value = "/checkEmployees", method = RequestMethod.POST)
	public String employees(@RequestParam String email, @RequestParam String password,HttpSession session){
	User u = userService.getUser(email, password);
	if(u == null){
		return "redirect:/";
	}
	else{
		session.setAttribute("user",u);
		return "redirect:details";
	}
	}
	
	@RequestMapping(value="/details")
	public ModelAndView employeesPage(HttpSession session) {
		ModelAndView res=new ModelAndView("details");
		
		//personal info
		User authenticatedUser=(User) session.getAttribute("user");
		res.addObject("autUser",authenticatedUser); 
		List<UserJobPosition> userJobPos=userService.getUserJobPositions(authenticatedUser);
		List<String> jobTitles=new ArrayList<>();
		List<Double> salaries=new ArrayList<>();
		
		for (UserJobPosition userJobPosition : userJobPos) {
		jobTitles.add(0,userService.getPositionName(userJobPosition.getJob_id()));
		salaries.add(0,userService.getSalary(userJobPosition.getSalary_id()));
		}
		res.addObject("userJobPositions",userJobPos);
		res.addObject("jobTitles",jobTitles);
		res.addObject("salaries",salaries);
		
		return res;
	}
	
	public String getUserName(Announcements a)
	{
		return userService.getUserName(a);
	}

}
