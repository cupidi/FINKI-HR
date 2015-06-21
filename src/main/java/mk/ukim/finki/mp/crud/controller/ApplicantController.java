package mk.ukim.finki.mp.crud.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
public class ApplicantController {
	@Autowired
	private UserService userService;


	@RequestMapping(value = "/applications")
	public ModelAndView list(HttpSession session) {
		User login = (User) session.getAttribute("user");
		if (login == null || !userService.isManager(login)) {
			return new ModelAndView("redirect:/");
		}
		
		ModelAndView res = new ModelAndView("applications");
	
		List<User> aplicatorsList = userService.getApplicants();
		
		res.addObject("aplicators", aplicatorsList);
		res.addObject("aplicatorsCount", aplicatorsList.size());
		
		res.addObject("manager", userService.isManager(login));
		
		return res;
	}
	
	@RequestMapping(value = "/application")
	public ModelAndView application(@RequestParam(value = "id", required = true) String id, HttpSession session) {
		User login = (User) session.getAttribute("user");
		if (login == null || !userService.isManager(login)) {
			return new ModelAndView("redirect:/");
		}
		
		ModelAndView res = new ModelAndView("application");
		
		int u_id = 0;
		try {
			u_id = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			return new ModelAndView("redirect:applications");
		}
		User user = userService.getUser(u_id);
		if (user == null) {
			return new ModelAndView("redirect:applications");
		}
		
		res.addObject("autUser", user);

		return res;
	}
	
	@RequestMapping(value = "/hire", method = RequestMethod.POST)
	public @ResponseBody String editPersonalInfo(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "value", required = true) String value, HttpSession session) {
			
		User login = (User) session.getAttribute("user");
		if (login == null || !userService.isManager(login)) {
			return "";
		}
		
		int u_id = 0;
		try {
			u_id = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			return "";
		}
		User user = userService.getUser(u_id);
		if (user == null) {
			return "";
		}
		
		if (value.equals("true")) {
			user.setHire_date(new Date());
			user.setType("employee");
			userService.editPersonalInfo(user);
		} else {
			userService.deleteUser(user);
		}
		
		
		return "";
	}
	
}
