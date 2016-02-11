package kh.com.kshrd.services;

import java.util.List;

import kh.com.kshrd.entities.Bill;

public interface BillService {

	public Boolean registerNewBill(Bill bill);
	
	
//	public Page<Bill> findByAccount(Account account, Pageable pageable);
	public List<Bill> findByAccountId(Long account_id);
	
}
