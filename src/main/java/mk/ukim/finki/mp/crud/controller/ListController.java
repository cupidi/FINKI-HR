package mk.ukim.finki.mp.crud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.mp.crud.UserValidator;
import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.model.UserJobPosition;
import mk.ukim.finki.mp.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	@Autowired
	private UserService userService;

	@Autowired
	UserValidator userValidator;


	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session) {
		
		if ((User) session.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		
		ModelAndView res = new ModelAndView("list");
		
		List<List<String>> jobs = new ArrayList<List<String>>();
		List<User> employees = userService.getAllUsers();
		for (User user : employees) {
			List<UserJobPosition> userJob = userService
					.getUserJobPositions(user);
			List<String> jobTitle = new ArrayList<>();
			for (UserJobPosition userJobPosition : userJob) {
				jobTitle.add(0, userService.getPositionName(userJobPosition
						.getJob_id()));
			}
			jobs.add(jobTitle);
		}
		res.addObject("job", jobs);
		res.addObject("numEmployees", employees.size());
		res.addObject("employees", employees);
		
		return res;
	}

}
