package mk.ukim.finki.mp.crud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.mp.crud.model.JobPositions;
import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	@Autowired
	private UserService userService;



	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session) {
		
		if ((User) session.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		
		ModelAndView res = new ModelAndView("list");
		
		List<String> jobs = new ArrayList<String>();
		List<User> employees = userService.getAllEmployees();
		for (User user : employees) {
			List<JobPositions> userJob = userService
					.getUserJobPositions(user);
			if (userJob.size() > 0)
				jobs.add(userJob.get(userJob.size() - 1).getPosition_name());
			else
				jobs.add("");
		}
		res.addObject("job", jobs);
		res.addObject("numEmployees", employees.size());
		res.addObject("employees", employees);
		
		res.addObject("manager", userService.isManager((User) session.getAttribute("user")));
		
		return res;
	}

}
