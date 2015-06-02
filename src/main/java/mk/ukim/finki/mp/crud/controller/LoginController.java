package mk.ukim.finki.mp.crud.controller;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.mp.crud.UserValidator;
import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	UserValidator userValidator;


	@RequestMapping(value = "/")
	public ModelAndView indexPage(HttpSession session) {
		ModelAndView res = new ModelAndView("login");
		if (session.getAttribute("user") == null)
			return res;
		return new ModelAndView("redirect:news");
	}

	
	@RequestMapping(value = "/checkEmployees", method = RequestMethod.POST)
	public String employees(@RequestParam String email,
			@RequestParam String password, HttpSession session) {
		User u = userService.getUser(email, password);
		if (u == null || u.getType().toLowerCase().equals("applicant")) {
			return "redirect:/";
		} else {
			session.setAttribute("user", u);
			return "redirect:news";
		}
	}

}
