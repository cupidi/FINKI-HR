package mk.ukim.finki.mp.crud.dao.impl;

import java.util.List;

import mk.ukim.finki.mp.crud.dao.UserDao;
import mk.ukim.finki.mp.crud.model.Announcements;
import mk.ukim.finki.mp.crud.model.JobPositions;
import mk.ukim.finki.mp.crud.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;


@Repository
@ComponentScan("mk.ukim.finki.mp.crud.dao.impl")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> users=getCurrentSession().createQuery("from User").list();
		return users;
	}

	@Override
	public User getUser(String mail, String password) {
		User u = (User) getCurrentSession().createQuery("from User where mail=:mail and password=:password").setParameter("mail", mail).setParameter("password", password).uniqueResult();
		return u;
	}
	
	@Override
	public List<Announcements> getAllAnnouncements() {
		List<Announcements> announcements=getCurrentSession().createQuery("from Announcements ORDER BY announcement_id DESC").list();
		return announcements;
	}

	@Override
	public String getUserName(Announcements a) {
		int user_id=a.getUser_id();
		String userName= (String) getCurrentSession().createQuery("select name from User u where u.user_id=:user_id ").setParameter("user_id", user_id).uniqueResult();
		return userName;
	}

	@Override
	public List<JobPositions> getUserJobPositions(User u) {
		int user_id=u.getUser_id();
		List<JobPositions> userjobpos=getCurrentSession().createQuery("from JobPositions where user_id=:user_id order by starting_date desc").setParameter("user_id", user_id).list();
		return userjobpos;
	}

	@Override
	public void addAnnouncement(Announcements a) {
		getCurrentSession().save(a);
	}

	@Override
	public void editPersonalInfo(User user) {
		getCurrentSession().update(user);
	}

	@Override
	public void deleteUser(User user) {
		getCurrentSession().delete(user);
	}

	@Override
	public void addJob(JobPositions job) {
		getCurrentSession().save(job);	
	}

	@Override
	public void addUser(User user) {
		getCurrentSession().save(user);	
	}
	
}
