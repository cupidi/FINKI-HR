package mk.ukim.finki.mp.crud.dao;

import java.util.List;

import mk.ukim.finki.mp.crud.model.Announcements;
import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.model.UserJobPosition;

public interface UserDao {

	public List<User> getAllUsers();
	
	public List<UserJobPosition> getUserJobPositions(User u);
	
	public String getPositionName(int job_id);
	
	public double getSalary(int salary_id);
	
	public User getUser(String mail, String password);
	
	public List<Announcements> getAllAnnouncements();
	
	public String getUserName(Announcements a);
	
	public void addAnnouncement(Announcements a);
	
	public void editPersonalInfo(User user);
	
	
}
