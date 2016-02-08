package kh.com.kshrd.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kh.com.kshrd.entities.User;

public interface UserService {

	public User findUserByEmail(String email);
	
	public User registerNewDonor(User user);
	
	public Page<User> findAllDonors(Pageable pageable);
	
}
