package kh.com.kshrd.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.kshrd.entities.User;
import kh.com.kshrd.services.UserService;

@Controller
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired 
	private UserService userService;
		
	@RequestMapping(value="/signup", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> signupDonor(@RequestBody User user){
		Map<String, Object> map = new HashMap<String, Object>();
		User registeredDonor = userService.registerNewDonor(user);
		if(null!=registeredDonor){
			map.put("RESP_DATA", registeredDonor);
			map.put("RESP_CODE", 200);
			map.put("RESP_MSG", "Donor has been signup successfully.");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}else{
			map.put("RESP_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
			map.put("RESP_MSG", "Donor has not been signup yet. Please try again.");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
