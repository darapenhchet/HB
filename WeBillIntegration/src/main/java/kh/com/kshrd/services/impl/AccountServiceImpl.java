package kh.com.kshrd.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.kshrd.entities.Account;
import kh.com.kshrd.repositories.AccountRepository;
import kh.com.kshrd.services.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountReposity;
	
	public Boolean registerNewAccount(Account account) {
		try{
			accountReposity.save(account);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Boolean updateExistingAccount(Account account) {
		try{
			Account existedAccount = accountReposity.findAccountByCustomerId(account.getCustomerId());
			if(existedAccount!=null){
				System.out.println("ACCOUNT ALREADY EXIST.");
				existedAccount.setAccountNo(account.getAccountNo());
				accountReposity.save(existedAccount);
				return true;
			}else{
				System.out.println("ACCOUNT NOT EXIST.");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Account findAccountByAccountNo(String accountNo) {
		return accountReposity.findAccountByAccountNo(accountNo);
	}
	
	@Override
	public Boolean save(Account account) {
		try{
			accountReposity.save(account);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}
