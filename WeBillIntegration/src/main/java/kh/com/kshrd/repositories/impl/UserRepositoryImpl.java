package kh.com.kshrd.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import kh.com.kshrd.entities.Role;
import kh.com.kshrd.entities.User;
import kh.com.kshrd.repositories.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Override
	public User findUserByEmail(String email) {
		try{
			User user = new User();
			user.setId(9988);
			user.setUsername("user@gmail.com");
			user.setName("Vuthea");
			user.setPassword(new BCryptPasswordEncoder().encode("password"));
			user.setEmail("user@gmail.com");
			user.setPhone("086961919");
			user.setCode("9876");
			user.setStatus(true);
			user.setRoles(getAllRolesByUserId(user.getId()));
			return user;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private List<Role> getAllRolesByUserId(int id){
		List<Role> roles = new ArrayList<Role>();
		try{
			Role role = new Role();
			role.setId(1);
			role.setName("ROLE_DONOR");
			roles.add(role);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return roles;
	}
	
}