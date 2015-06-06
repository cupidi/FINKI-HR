package mk.ukim.finki.mp.crud.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.mp.crud.model.Announcements;
import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {

	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/news")
	public ModelAndView news(HttpSession session) {
		
		User authenticatedUser = (User) session.getAttribute("user");
		if (authenticatedUser == null) {
			return new ModelAndView("redirect:/");
		}
		
		ModelAndView res = new ModelAndView("news");
		
		res.addObject("autUser", authenticatedUser);
		
		List<Announcements> announcements = userService.getAllAnnouncements();
		res.addObject("announcements", announcements);
		
		HashMap<Integer, String> userNames = new HashMap<Integer, String>();
		for (Announcements a : announcements) {
			userNames.put((int) a.getAnnouncement_id(), userService.getUserName(a));
		}
		res.addObject("userNames", userNames);
		
		res.addObject("manager", userService.isManager(authenticatedUser));
		
		return res;
	}
	
	@RequestMapping(value = "/addedAnnouncement", method = RequestMethod.POST)
	public String addedAnn(@RequestParam String title,
			@RequestParam String announcement, HttpSession session) {
		User authenticatedUser = (User) session.getAttribute("user");

		if (authenticatedUser == null) {
			return "redirect:/";
		}
		
		Announcements a = new Announcements();
		a.setAnnouncement(announcement);
		a.setAnnouncement_title(title);
		Date date = new Date();
		a.setDatum(date);
		a.setUser_id(authenticatedUser.getUser_id());
		userService.addAnnouncement(a);
		
		return "redirect:news";
	}
	
}
