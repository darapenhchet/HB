package kh.com.kshrd.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

@Entity
@Table(name="accounts")
public class Account extends ResourceSupport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2956078069895251545L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="account_id")
	private Long accountId;
	
	@Column(name="customer_id")
	private Long customerId;

	/**
	 * @return the id
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * @param id the id to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}