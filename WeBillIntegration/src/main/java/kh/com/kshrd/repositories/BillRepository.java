package kh.com.kshrd.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import kh.com.kshrd.entities.Bill;

public interface BillRepository extends PagingAndSortingRepository<Bill, Long> {
	
}
