package mk.ukim.finki.mp.crud.service;

import java.util.List;

import mk.ukim.finki.mp.crud.model.Announcements;
import mk.ukim.finki.mp.crud.model.JobPositions;
import mk.ukim.finki.mp.crud.model.User;

public interface UserService {

	public List<User> getAllUsers();
	
	public List<User> getApplicants();
	
	public List<User> getAllEmployees();
	
	public User getUser(String mail, String password);
	
	public List<JobPositions> getUserJobPositions(User u);
	
	public void editPersonalInfo(User user);
	
	public boolean isManager(User user);
	
	public User getUser(int id);
	
	public void deleteUser(User user);
	
	public void addUser(User user);
	
	public void addJob(JobPositions job);
	
	
	
	
	public List<Announcements> getAllAnnouncements();
	
	public String getUserName(Announcements a);
	
	public void addAnnouncement(Announcements a);
	
	
}
