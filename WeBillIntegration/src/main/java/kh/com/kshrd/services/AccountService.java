package kh.com.kshrd.services;

import kh.com.kshrd.entities.Account;

public interface AccountService {

	public Account findAccountByAccountNo(String accountNo);
	
	public Boolean registerNewAccount(Account account);
	
	public Boolean updateExistingAccount(Account account);
	
	public Boolean save(Account account);
}
