package kh.com.kshrd.services;

import kh.com.kshrd.entities.User;

public interface UserService {

	public User findUserByEmail(String email);
	
	public User registerNewDonor(User user);
	
}
