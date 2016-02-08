package kh.com.kshrd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.kshrd.entities.Account;
import kh.com.kshrd.entities.Bill;
import kh.com.kshrd.services.AccountService;
import kh.com.kshrd.services.BillService;

@Controller
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/account/{accountId}/bills", method=RequestMethod.GET)
	@ResponseBody
	public Page<Bill> findAllBillByDonorId(@PathVariable("accountId") Long accountId, @PageableDefault(size = 20, page = 0) Pageable pageable){
		Account account = accountService.findOne(accountId);
		Page<Bill> bills = billService.findByAccount(account, pageable);
		return bills;
		
	}

}
