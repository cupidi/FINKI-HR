package mk.ukim.finki.mp.crud.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register")
	public ModelAndView register(HttpSession session) {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/registerUser", headers = "content-type=multipart/*", method = RequestMethod.POST)
	public String registerUser(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "surname", required = true) String surname,
			@RequestParam(value = "birthdate", required = true) String birthdate,
			@RequestParam(value = "phone", required = true) String phone,
			@RequestParam(value = "mail", required = true) String mail,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "cv", required = true) MultipartFile cv,
			@RequestParam(value = "picture", required = true) MultipartFile picture,
			@RequestParam(value = "address", required = true) String address, HttpSession session) {
		
	
		User newUser = new User();
		
		if (birthdate != null) {
			DateFormat formatter;
			Date date = null;
			formatter = new SimpleDateFormat("YYYY-MM-DD");
			try {
				date = (Date) formatter.parse(birthdate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			newUser.setBirth_date(date);
		}

		newUser.setMail(mail);
		newUser.setName(name);
		newUser.setSurname(surname);
		newUser.setPhone(phone);
		newUser.setMail(mail);
		newUser.setPassword(password);
		newUser.setType("applicant");
		newUser.setApplication_date(new Date());
		newUser.setCv(cv.getOriginalFilename());
		newUser.setPicture(picture.getOriginalFilename());
		
		userService.addUser(newUser);
		
		try {
			cv.transferTo(new File(".cv/" + (cv.getOriginalFilename())));
			picture.transferTo(new File(".images/" + picture.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "redirect:/";
	}
	
	
}
