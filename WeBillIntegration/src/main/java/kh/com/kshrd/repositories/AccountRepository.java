package kh.com.kshrd.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import kh.com.kshrd.entities.Account;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

	public Account findAccountByCustomerId(@Param("customerId") Long customerId);
	
	public Account findAccountByAccountNo(@Param("accountNo") String accountNo);
	
}
