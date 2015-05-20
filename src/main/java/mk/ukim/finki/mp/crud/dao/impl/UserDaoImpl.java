package mk.ukim.finki.mp.crud.dao.impl;

import java.util.List;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.mp.crud.dao.UserDao;
import mk.ukim.finki.mp.crud.model.User;


@Repository
@ComponentScan("mk.ukim.finki.mp.crud.dao.impl")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		
		return sessionFactory.getCurrentSession();
	}
	

	@Override
	public User getUser(String mail, String password) {
		// TODO Auto-generated method stub
		User u = (User) getCurrentSession().createQuery("from User where mail=:mail and password=:password").setParameter("mail", mail).setParameter("password", password).uniqueResult();
		return u;
	}

	
}
