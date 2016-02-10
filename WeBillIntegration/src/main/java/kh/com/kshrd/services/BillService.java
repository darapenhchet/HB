package kh.com.kshrd.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kh.com.kshrd.entities.Account;
import kh.com.kshrd.entities.Bill;

public interface BillService {

	public Boolean registerNewBill(Bill bill);
	
	//public Page<Bill> findByAccount(Account account, Pageable pageable);
	
}
