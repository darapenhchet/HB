package kh.com.kshrd.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kh.com.kshrd.entities.Account;
import kh.com.kshrd.entities.Bill;
import kh.com.kshrd.repositories.BillRepository;
import kh.com.kshrd.services.BillService;

@Service
@Transactional
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	@Override
	public Boolean registerNewBill(Bill bill) {
		try{
			billRepository.save(bill);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	/*@Override
	public Page<Bill> findByAccount(Account account, Pageable pageable) {
		return billRepository.findByAccount(account, pageable);
	}*/

}
