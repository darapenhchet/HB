package kh.com.kshrd.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

@Entity
@Table(name="bills")
public class Bill extends ResourceSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6471595557319732624L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bill_id")
	private Long billId;
	
	@Column(name="billing_id")
	private Long biilingId;

	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="expiry_date")
	private Date expiryDate;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Account account;

	/**
	 * @return the billId
	 */
	public Long getBillId() {
		return billId;
	}

	/**
	 * @param billId the billId to set
	 */
	public void setBillId(Long billId) {
		this.billId = billId;
	}

	/**
	 * @return the biilingId
	 */
	public Long getBiilingId() {
		return biilingId;
	}

	/**
	 * @param biilingId the biilingId to set
	 */
	public void setBiilingId(Long biilingId) {
		this.biilingId = biilingId;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
