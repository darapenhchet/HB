package kh.com.kshrd.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kh.com.kshrd.entities.Role;
import kh.com.kshrd.entities.User;
import kh.com.kshrd.repositories.RoleRepository;
import kh.com.kshrd.repositories.UserRepository;
import kh.com.kshrd.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		try{
			return userRepository.findUserByEmail(email);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public User registerNewDonor(User user) {
		try{
			Role role = roleRepository.findRoleByName("ROLE_DONOR");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.getRoles().add(role);
			user.setStatus(true);
			userRepository.save(user);
			return user;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<User> findAllDonors() {
		return (List<User>) userRepository.findAll();
	}
	
}
