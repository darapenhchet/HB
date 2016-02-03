package kh.com.kshrd.repositories.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import kh.com.kshrd.entities.Customer;

@Repository
public class DonateRepositoryImpl {
			
	public Customer createNewDonate(Customer customer){
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("expiry_date", "");
		input.put("remark", "REMARK");
		input.put("customer_code", "8899");
		input.put("customer_name", "test");
		input.put("customer_email", "cndtls@gmail.com");
		input.put("customer_phone", "092333208");
		input.put("currency", "USD");
		input.put("amount", "10.00");
		input.put("customer_id", customer.getCustomerId());
		/*HttpEntity<Object> request = new HttpEntity<Object>(headers);
		ResponseEntity<Map> response = restTemplate.exchange("", HttpMethod.POST , request , Map.class);*/
		return null;
	}
	
	public static void main(String args[]){
		
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("expiry_date", "20160229");
		input.put("remark", "HRD DONATION BILLING SYSTEM");
		input.put("customer_code", "7777");
		input.put("customer_name", "DARA PENHCHET");
		input.put("customer_email", "darapenhchet@gmail.com");
		input.put("customer_phone", "086961919");
		input.put("currency", "USD");
		input.put("amount", "1.00");
		//input.put("customer_id", customer.getCustomerId());
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Basic Y29tdGhyZWU6Y29tdGhyZWU=");
		HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(input, headers);  
		ResponseEntity<Map> response = restTemplate.exchange("http://apitest.wecambodia.com/webill/v1/orders", HttpMethod.POST , request , Map.class);
		System.out.println(response.getBody());
	}
}
