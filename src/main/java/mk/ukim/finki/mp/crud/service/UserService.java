package mk.ukim.finki.mp.crud.service;

import java.util.List;

import mk.ukim.finki.mp.crud.model.Announcements;
import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.model.UserJobPosition;

public interface UserService {

	public List<User> getAllUsers();
	
	public User getUser(String mail, String password);
	
    public String getPositionName(int job_id);
	
	public double getSalary(int salary_id);
	
	public List<Announcements> getAllAnnouncements();
	
	public String getUserName(Announcements a);
	
	public List<UserJobPosition> getUserJobPositions(User u);
	
	public void addAnnouncement(Announcements a);
}
