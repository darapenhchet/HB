package kh.com.kshrd.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import kh.com.kshrd.entities.Account;
import kh.com.kshrd.entities.Bill;

public interface BillRepository extends PagingAndSortingRepository<Bill, Long> {
	
//	@Query(value = "SELECT B.bill_id, B.amount, B.currency, B.created_date FROM Bills B INNER JOIN Billings BI ON B.bill_id=BI.bill_id INNER JOIN Accounts A ON BI.account_id=A.Account_id", nativeQuery = true)
//	List<Bill> findByAccountId(Long account_id); 
	
	//public Page<Bill> findByAccount(Account account, Pageable pageable);
	
	@Query("SELECT b FROM Bill b INNER JOIN b.accounts c WHERE c IN (:accounts)")
	public List<Bill> findByAccounts(@Param("accounts")Collection<Account> accounts);
}
