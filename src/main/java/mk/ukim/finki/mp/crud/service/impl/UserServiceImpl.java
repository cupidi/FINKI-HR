package mk.ukim.finki.mp.crud.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import mk.ukim.finki.mp.crud.dao.UserDao;
import mk.ukim.finki.mp.crud.model.Announcements;
import mk.ukim.finki.mp.crud.model.JobPositions;
import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<JobPositions> getUserJobPositions(User u) {
		// TODO Auto-generated method stub
		return userDao.getUserJobPositions(u);
	}

//	@Override
//	public String getPositionName(int job_id) {
//		// TODO Auto-generated method stub
//		return userDao.getPositionName(job_id);
//	}
//
//	@Override
//	public double getSalary(int salary_id) {
//		// TODO Auto-generated method stub
//		return userDao.getSalary(salary_id);
//	}

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

	@Override
	public boolean isManager(User user) {
		// TODO Auto-generated method stub
		return user.getType().toLowerCase().equals("manager");
	}

	@Override
	public User getUser(int id) {
		List<User> employees = getAllUsers();
		for (User temp : employees) {
			if (temp.getUser_id() == id) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public List<User> getApplicants() {
		List<User> aplikanti = new ArrayList<User>();
		for (User usr : getAllUsers()) {
			if (usr.getType().toLowerCase().equals("applicant")) {
				aplikanti.add(usr);
			}
		}
		return aplikanti;
	}

	@Override
	public List<User> getAllEmployees() {
		List<User> aplikanti = new ArrayList<User>();
		for (User usr : getAllUsers()) {
			if (!usr.getType().toLowerCase().equals("applicant")) {
				aplikanti.add(usr);
			}
		}
		return aplikanti;
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	@Override
	public void addJob(JobPositions job) {
		userDao.addJob(job);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public String getBirthdayData(){
		List<User> users = getAllUsers();
		int data[] = new int[12];
		for(User user: users){
			if (!user.getType().equals("applicant")) {
				Date date = user.getBirth_date();
				if(date == null) continue;
				data[date.getMonth()] ++;	
			}
		}
		return Arrays.toString(data);
	}

	@Override
	public Map<String,Integer> getSalaryByEmployee() {
		return userDao.getSalaryByEmployee();
	}
	

	@Override
	public String getTotalSalaryExpensesByMonth(){
		return userDao.getTotalSalaryExpensesByMonth();
	}
	
}
