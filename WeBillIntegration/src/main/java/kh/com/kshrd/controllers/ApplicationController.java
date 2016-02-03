package kh.com.kshrd.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/apps")
public class ApplicationController {

	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> home(){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("APP_NAME", "WEBILL_INTEGRATION");
		model.put("APP_VERSION", "V.0.0.1");
		model.put("APP_CREATED_DATE", "01-02-2016");
		return new ResponseEntity<Map<String, Object>>(model, HttpStatus.OK);
	}
}
