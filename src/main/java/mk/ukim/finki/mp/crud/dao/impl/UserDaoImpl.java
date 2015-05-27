package mk.ukim.finki.mp.crud.dao.impl;

import java.util.List;











import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.mp.crud.dao.UserDao;
import mk.ukim.finki.mp.crud.model.Announcements;
import mk.ukim.finki.mp.crud.model.User;
import mk.ukim.finki.mp.crud.model.UserJobPosition;


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
		// TODO Auto-generated method stub
		User u = (User) getCurrentSession().createQuery("from User where mail=:mail and password=:password").setParameter("mail", mail).setParameter("password", password).uniqueResult();
		return u;
	}

	
	@Override
	public List<Announcements> getAllAnnouncements() {
		// TODO Auto-generated method stub
		List<Announcements> announcements=getCurrentSession().createQuery("from Announcements ORDER BY announcement_id DESC").list();
		return announcements;
	}

	@Override
	public String getUserName(Announcements a) {
		// TODO Auto-generated method stub
		int user_id=a.getUser_id();
		String userName= (String) getCurrentSession().createQuery("select name from User u where u.user_id=:user_id ").setParameter("user_id", user_id).uniqueResult();
		return userName;
	}

	@Override
	public List<UserJobPosition> getUserJobPositions(User u) {
		// TODO Auto-generated method stub
		int user_id=u.getUser_id();
		List<UserJobPosition> userjobpos=getCurrentSession().createQuery("from UserJobPosition where user_id=:user_id").setParameter("user_id", user_id).list();
		return userjobpos;
	}

	@Override
	public String getPositionName(int job_id) {
		// TODO Auto-generated method stub
		return (String) getCurrentSession().createQuery("select position_name from JobPositions where job_id=:job_id").setParameter("job_id", job_id).uniqueResult();
	}

	@Override
	public double getSalary(int salary_id) {
		// TODO Auto-generated method stub
		return (double) getCurrentSession().createQuery("select salary from SalaryInfo where salary_id=:salary_id").setParameter("salary_id", salary_id).uniqueResult();
	}

	@Override
	public void addAnnouncement(Announcements a) {
		// TODO Auto-generated method stub
		getCurrentSession().save(a);
	}

	@Override
	public void editPersonalInfo(User user) {
		// TODO Auto-generated method stub
		getCurrentSession().update(user);
	}

	
}
