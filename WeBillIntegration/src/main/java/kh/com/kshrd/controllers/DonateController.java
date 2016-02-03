package kh.com.kshrd.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import kh.com.kshrd.entities.Customer;

@Controller
@RequestMapping(value="/donates")
public class DonateController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addNewDonate(@RequestBody Customer customer){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			Map<String, Object> input = new HashMap<String, Object>();
			input.put("expiry_date", "20160229");
			input.put("remark", "HRD DONATION BILLING SYSTEM");
			input.put("customer_code", customer.getCustomerCode());
			input.put("customer_name", customer.getCustomerName());
			input.put("customer_email", customer.getCustomerEmail());
			input.put("customer_phone", customer.getCustomerPhone());
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

}
