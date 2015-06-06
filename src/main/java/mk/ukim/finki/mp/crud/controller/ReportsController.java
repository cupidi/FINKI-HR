package mk.ukim.finki.mp.crud.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.mp.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportsController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/reports")
	public ModelAndView register(HttpSession session) {
		//session.setAttribute("birthdayData", userService.getBirthdayData());
		ModelAndView mv = new ModelAndView("reports");
		mv.addObject("birthdayData", userService.getBirthdayData());
		mv.addObject("salaryExpenses",userService.getTotalSalaryExpensesByMonth());
		Map<String,Integer> map = userService.getSalaryByEmployee();
		
		mv.addObject("employees",map.keySet());
		mv.addObject("salaries", map.values());
		return mv;
	}	
}
