package kh.com.kshrd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.kshrd.entities.User;
import kh.com.kshrd.repositories.UserRepository;
import kh.com.kshrd.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUserByEmail(String email) {
		try{
			return userRepository.findUserByEmail(email);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
