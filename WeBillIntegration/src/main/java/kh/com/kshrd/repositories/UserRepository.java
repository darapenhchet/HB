package kh.com.kshrd.repositories;

import kh.com.kshrd.entities.User;

public interface UserRepository {
	
	public User findUserByEmail(String email);
}
