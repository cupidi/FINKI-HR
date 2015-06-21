package mk.ukim.finki.mp.crud.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = getCurrentSession().createQuery("from User").list();
		return users;
	}

	@Override
	public User getUser(String mail, String password) {
		User u = (User) getCurrentSession()
				.createQuery(
						"from User where mail=:mail and password=:password")
				.setParameter("mail", mail).setParameter("password", password)
				.uniqueResult();
		return u;
	}

	@Override
	public List<Announcements> getAllAnnouncements() {
		List<Announcements> announcements = getCurrentSession().createQuery(
				"from Announcements ORDER BY announcement_id DESC").list();
		return announcements;
	}

	@Override
	public String getUserName(Announcements a) {
		int user_id = a.getUser_id();
		String userName = (String) getCurrentSession()
				.createQuery(
						"select name from User u where u.user_id=:user_id ")
				.setParameter("user_id", user_id).uniqueResult();
		return userName;
	}

	@Override
	public List<JobPositions> getUserJobPositions(User u) {
		int user_id = u.getUser_id();
		List<JobPositions> userjobpos = getCurrentSession()
				.createQuery(
						"from JobPositions where user_id=:user_id order by starting_date desc")
				.setParameter("user_id", user_id).list();
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

	@Override
	public Map<String, Integer> getSalaryByEmployee() {
		List<User> users = getCurrentSession().createQuery("from User").list();
		List<JobPositions> sinfo = getCurrentSession().createQuery(
				"from JobPositions").list();

		Map<String, Integer> res = new HashMap<String, Integer>();

		for (User u : users) {
			if (!u.getType().equals("applicant")) {
				Date date = new Date(0);
				int salary = 0;
				for (JobPositions s : sinfo) {
					if (u.getUser_id() == s.getUser_id()) {
						if (date.before(s.getStarting_date())) {
							date = s.getStarting_date();
							salary = (int) s.getSalary();
						}
					}
				}
				res.put("\"" + u.getName() + "\"", salary);
			}
		}

		return res;
	}

	@Override
	public String getTotalSalaryExpensesByMonth() {
		List<User> users = getCurrentSession().createQuery("from User").list();

		List<JobPositions> sinfo = getCurrentSession().createQuery(
				"from JobPositions").list();

		int res[] = new int[12];
		int currentmonth = new Date(System.currentTimeMillis()).getMonth();
		for (User u : users) {
			if (!u.getType().equals("applicant")) {
				Date date = new Date(0);
				int salary = 0;
				List<JobPositions> user_salary = new ArrayList<JobPositions>();
				for (JobPositions s : sinfo) {
					if (u.getUser_id() == s.getUser_id()) {
						user_salary.add(s);
					}
				}
	
				Collections.sort(user_salary, new Comparator<JobPositions>() {
					@Override
					public int compare(JobPositions f, JobPositions s) {
						if (f.getStarting_date().before(s.getStarting_date()))
							return -1;
						else
							return 1;
					}
				});
				
				int user_salary_by_month[] = new int[12];
				for(JobPositions s :user_salary){
					int month = s.getStarting_date().getMonth();
					for(int i = month; i<=currentmonth; i++){
						user_salary_by_month[i] = (int) s.getSalary();
					}
					
				}
				for(int i = 0; i<12; i++){
					res[i] += user_salary_by_month[i];
				}
			}
			
		}

		return Arrays.toString(res);
	}
}
