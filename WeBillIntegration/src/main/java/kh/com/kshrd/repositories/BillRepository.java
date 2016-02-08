package kh.com.kshrd.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import kh.com.kshrd.entities.Account;
import kh.com.kshrd.entities.Bill;

public interface BillRepository extends PagingAndSortingRepository<Bill, Long> {
	
	public Page<Bill> findByAccount(Account account, Pageable pageable);
}
