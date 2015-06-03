package mk.ukim.finki.mp.crud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mk.ukim.finki.mp.crud.UserValidator;
import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.service.UserService;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {

	@Autowired
	private UserService userService;

	@Autowired
	UserValidator userValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "birth_date",
				new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/register")
	public String displayRegistrationForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";

	}

//	@RequestMapping(value = "/registerDo", method = RequestMethod.POST)
//	public ModelAndView registration(@ModelAttribute User user,
//			BindingResult bindingResult) {
//		userValidator.validate(user, bindingResult);
//		if (bindingResult.hasErrors()) {
//			ModelAndView model = new ModelAndView("register");
//			model.addObject("user", user);
//			return model;
//		} else {
//
//			SessionFactory factory = HibernateUtil.getSessionFactory();
//			Session session = factory.openSession();
//			session.beginTransaction();
//			int br = 0;
//
//			Query query = session
//					.createQuery("select ssn from User where mail=:mail");
//			Query query1 = session
//					.createQuery("select ssn from User where password=:password");
//
//			query1.setParameter("password", user.getPassword());
//			query.setParameter("mail", user.getMail());
//
//			List result = query.list();
//			List result1 = query1.list();
//
//			if (result.size() != 0) {
//				bindingResult.rejectValue("mail", "mail.bad1");
//				br++;
//			}
//			if (result1.size() != 0) {
//				bindingResult.rejectValue("password", "password.bad1");
//				br++;
//			}
//
//			ModelAndView model;
//			if (br != 0) {
//				model = new ModelAndView("register");
//				model.addObject("user", user);
//				session.close();
//			} else {
//
//				user.setType("Applicant");
//				// Query
//				// query3=session.createQuery("select user_id from User where type=:type");
//				// query3.setParameter("type","Manager");
//				// List list3=query3.list();
//				// int manager_id=(int) list3.get(0);
//				// user.setManager_id(manager_id);
//				session.save(user);
//
//				session.getTransaction().commit();
//				model = new ModelAndView("Uspesno");
//
//			}
//			return model;
//
//		}
//	}

}
