package kh.com.kshrd.entities;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

public class Billing extends ResourceSupport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7067060905300988175L;

	private int billingId;
	
	private String billerId;
	
	private String billerCode;
	
	private String customerId;
	
	private String accountNo;
	
	private double amount;
	
	private String expiryDate;
	
	private String remark;
	
	private String currency;
	
	private String billingType;
	
	private String createdDate;
	
	private String createdBy;
	
	private String updatedDate;
	
	private String updatedBy;
	
	private String deletedDate;
	
	private String deletedBy;
	
	private String status;
	
	/**
	 * @return the billingId
	 */
	public int getBillingId() {
		return billingId;
	}
	/**
	 * @param billingId the billingId to set
	 */
	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}
	/**
	 * @return the billerId
	 */
	public String getBillerId() {
		return billerId;
	}
	/**
	 * @param billerId the billerId to set
	 */
	public void setBillerId(String billerId) {
		this.billerId = billerId;
	}
	/**
	 * @return the billerCode
	 */
	public String getBillerCode() {
		return billerCode;
	}
	/**
	 * @param billerCode the billerCode to set
	 */
	public void setBillerCode(String billerCode) {
		this.billerCode = billerCode;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
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
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @return the billingType
	 */
	public String getBillingType() {
		return billingType;
	}
	/**
	 * @param billingType the billingType to set
	 */
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}
	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the deletedDate
	 */
	public String getDeletedDate() {
		return deletedDate;
	}
	/**
	 * @param deletedDate the deletedDate to set
	 */
	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}
	/**
	 * @return the deletedBy
	 */
	public String getDeletedBy() {
		return deletedBy;
	}
	/**
	 * @param deletedBy the deletedBy to set
	 */
	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
