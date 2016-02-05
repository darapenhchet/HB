package kh.com.kshrd.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import kh.com.kshrd.entities.Customer;
import kh.com.kshrd.entities.User;

@Controller
@RequestMapping(value="/donates")
public class DonateController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addNewDonate(@RequestBody Customer customer){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			Map<String, Object> input = new HashMap<String, Object>();
			// TODO: GET USER AUTHENTICATED FROM THE SECURITY CONTEXT 
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = (User) authentication.getPrincipal();
			
			// TODO: EXPIRATION DATE IS 1 MONTH AFTER DONATION DATE
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, 1);
			
			input.put("expiry_date", simpleDateFormat.format(calendar.getTime()));
			input.put("remark", "HRD DONATION BILLING SYSTEM");
			input.put("customer_code", user.getCode());
			input.put("customer_name", user.getName());
			input.put("customer_email", user.getEmail());
			input.put("customer_phone", user.getPhone());
			input.put("currency", "USD");
			input.put("amount", customer.getAmount());
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Basic Y29tdGhyZWU6Y29tdGhyZWU=");
			HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(input, headers);  
			ResponseEntity<Map> response = restTemplate.exchange("http://apitest.wecambodia.com/webill/v1/orders", HttpMethod.POST , request , Map.class);
			System.out.println(response.getBody());
			map.put("RESP_DATA", response.getBody());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}catch(Exception ex){
			map.put("RESP_DATA", ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String donate(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		System.out.println(user.getEmail());
		System.out.println(user.getAuthorities());
		return "donation";
	}

}
