package mk.ukim.finki.mp.crud.service;

import java.util.List;

import mk.ukim.finki.mp.crud.model.User;

public interface UserService {

	
	public User getUser(String mail, String password);
	
	
}
