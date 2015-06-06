package mk.ukim.finki.mp.crud.dao;

import java.util.List;

import mk.ukim.finki.mp.crud.model.Announcements;
import mk.ukim.finki.mp.crud.model.JobPositions;
import mk.ukim.finki.mp.crud.model.User;

public interface UserDao {

	public List<User> getAllUsers();
	
	public List<JobPositions> getUserJobPositions(User u);

	public User getUser(String mail, String password);
	
	public List<Announcements> getAllAnnouncements();
	
	public String getUserName(Announcements a);
	
	public void addAnnouncement(Announcements a);
	
	public void editPersonalInfo(User user);
	
	public void deleteUser(User user);
	
	public void addJob(JobPositions job);
	
	public void addUser(User user);
	
	
}
