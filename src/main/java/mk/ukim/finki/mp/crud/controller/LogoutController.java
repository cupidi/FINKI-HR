package mk.ukim.finki.mp.crud.controller;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.mp.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController
{
	@Autowired
	private UserService userService;


	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/";
	}
	
}
