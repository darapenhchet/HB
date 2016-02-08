package kh.com.kshrd.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import kh.com.kshrd.entities.Biller;

@RepositoryRestResource(collectionResourceRel = "billers", path = "billers")
public interface BillRepository extends PagingAndSortingRepository<Biller, Long> {

    List<Biller> findBybillerName(@Param("name") String billerName);
}
