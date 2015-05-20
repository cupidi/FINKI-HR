package mk.ukim.finki.mp.crud.controller;

import java.util.List;

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
	public ModelAndView indexPage() {
		ModelAndView res=new ModelAndView("login");
		return res;
	}
	
	@RequestMapping(value = "/checkEmployees", method = RequestMethod.POST)
	public String employees(@RequestParam String email, @RequestParam String password){
	User u = userService.getUser(email, password);
	if(u == null){
		return "redirect:/";
	}
	else{
		return "redirect:employees";
	}
	}
	
	@RequestMapping(value="/employees")
	public ModelAndView employeesPage() {
		ModelAndView res=new ModelAndView("employees");
		List<User> employees = userService.getAllUsers();
		res.addObject("numEmployees",employees.size());
		res.addObject("employees", employees);
		return res;
	}

}
