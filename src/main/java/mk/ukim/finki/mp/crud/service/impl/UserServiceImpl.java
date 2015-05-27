package mk.ukim.finki.mp.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mk.ukim.finki.mp.crud.dao.UserDao;
import mk.ukim.finki.mp.crud.model.Announcements;
import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.model.UserJobPosition;
import mk.ukim.finki.mp.crud.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	@Override
	public User getUser(String mail, String password) {
		// TODO Auto-generated method stub
		return userDao.getUser(mail, password);
	}

	@Override
	public List<Announcements> getAllAnnouncements() {
		// TODO Auto-generated method stub
		return userDao.getAllAnnouncements();
	}

	@Override
	public String getUserName(Announcements a) {
		// TODO Auto-generated method stub
		return userDao.getUserName(a);
	}

	@Override
	public List<UserJobPosition> getUserJobPositions(User u) {
		// TODO Auto-generated method stub
		return userDao.getUserJobPositions(u);
	}

	@Override
	public String getPositionName(int job_id) {
		// TODO Auto-generated method stub
		return userDao.getPositionName(job_id);
	}

	@Override
	public double getSalary(int salary_id) {
		// TODO Auto-generated method stub
		return userDao.getSalary(salary_id);
	}

	@Override
	public void addAnnouncement(Announcements a) {
		// TODO Auto-generated method stub
		userDao.addAnnouncement(a);
	}

	@Override
	public void editPersonalInfo(User user) {
		// TODO Auto-generated method stub
		userDao.editPersonalInfo(user);
	}

	
}
