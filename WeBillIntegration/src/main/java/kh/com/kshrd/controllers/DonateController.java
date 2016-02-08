package kh.com.kshrd.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import kh.com.kshrd.entities.Account;
import kh.com.kshrd.entities.Bill;
import kh.com.kshrd.entities.User;
import kh.com.kshrd.filters.DonationFilter;
import kh.com.kshrd.services.AccountService;
import kh.com.kshrd.services.BillService;

@Controller
@RequestMapping(value="/donates")
public class DonateController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BillService billService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addNewDonate(@RequestBody DonationFilter donationFilter){
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
			input.put("customer_code", user.getId());
			input.put("customer_name", user.getName());
			input.put("customer_email", user.getEmail());
			input.put("customer_phone", user.getPhone());
			input.put("currency", "USD");
			input.put("amount", donationFilter.getAmount());
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Basic Y29tdGhyZWU6Y29tdGhyZWU=");
			HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(input, headers);  
			ResponseEntity<Map> response = restTemplate.exchange("http://apitest.wecambodia.com/webill/v1/orders", HttpMethod.POST , request , Map.class);
			System.out.println(response.getBody());
			Map<String, Object> mapResponseBody = (HashMap<String, Object>)response.getBody();
			if(mapResponseBody.get("response_code").equals("200")){
				Account account = accountService.findAccountByAccountNo((String) mapResponseBody.get("account_no"));
				if(account==null){
					System.out.println("NULL");
					account = new Account();
					account.setAccountNo((String) mapResponseBody.get("account_no"));
					account.setCustomerId(Long.valueOf((String)mapResponseBody.get("customer_id")));
					account.setUser(user);
					Bill bill = new Bill();
					bill.setBiilingId(Long.valueOf((String)mapResponseBody.get("billing_id")));
					bill.setAmount(donationFilter.getAmount());
					bill.setCreatedDate(new Date());
					bill.setCurrency("USD");
					bill.setExpiryDate(calendar.getTime());
					bill.setAccount(account);
					billService.registerNewBill(bill);
					map.put("RESP_DATA", response.getBody());
				}else{
					System.out.println("NOT NULL");
					Bill bill = new Bill();
					bill.setBiilingId(Long.valueOf((String)mapResponseBody.get("billing_id")));
					bill.setAmount(donationFilter.getAmount());
					bill.setCreatedDate(new Date());
					bill.setCurrency("USD");
					bill.setExpiryDate(calendar.getTime());
					bill.setAccount(account);
					account.getBills().add(bill);
					System.out.println(account.getBills());
					billService.registerNewBill(bill);
					map.put("RESP_DATA", response.getBody());
				}
			}else{
				map.put("RESP_DATA", response.getBody());
			}
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
