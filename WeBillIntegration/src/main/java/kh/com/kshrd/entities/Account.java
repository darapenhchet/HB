package kh.com.kshrd.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="customer_id")
	private Long customerId;
	
	@Column(name="account_no")
	private String accountNo;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "account")
	private Set<Bill> bills = new HashSet<Bill>();

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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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

	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the bills
	 */
	public Set<Bill> getBills() {
		return bills;
	}

	/**
	 * @param bills the bills to set
	 */
	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}
	
	
}