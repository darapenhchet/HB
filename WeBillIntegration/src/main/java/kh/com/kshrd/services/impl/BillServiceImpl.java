package kh.com.kshrd.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.kshrd.entities.Account;
import kh.com.kshrd.entities.Bill;
import kh.com.kshrd.repositories.AccountRepository;
import kh.com.kshrd.repositories.BillRepository;
import kh.com.kshrd.services.BillService;

@Service
@Transactional
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
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

	@Override
	public List<Bill> findByAccountId(Long account_id) {
		Account account = accountRepository.findOne(account_id);
		Collection<Account> accounts = new ArrayList<Account>();
		accounts.add(account);
		return billRepository.findByAccounts(accounts);
	}

	
//	@Override
//	public List<Bill> findByAccountId(Long account_id) {
//		return billRepository.findByAccountId(account_id);
//	}
	
	
}
