package kh.com.kshrd.entities;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

public class Biller extends ResourceSupport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4710728028462657414L;

	private int billerId;
	
	private String billerCode;
	
	private String billerName;
	
	private String billerPhone;
	
	private String billerEmail;
	
	private String accountNo;
	
	private String authorizationBasic;
	
	private String createdDate;
	
	private String createdBy;
	
	private String updatedDate;
	
	private String updatedBy;
	
	private String deletedDate;
	
	private String deletedBy;
	
	private String status;

	/**
	 * @return the billerId
	 */
	public int getBillerId() {
		return billerId;
	}

	/**
	 * @param billerId the billerId to set
	 */
	public void setBillerId(int billerId) {
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
	 * @return the billerName
	 */
	public String getBillerName() {
		return billerName;
	}

	/**
	 * @param billerName the billerName to set
	 */
	public void setBillerName(String billerName) {
		this.billerName = billerName;
	}

	/**
	 * @return the billerPhone
	 */
	public String getBillerPhone() {
		return billerPhone;
	}

	/**
	 * @param billerPhone the billerPhone to set
	 */
	public void setBillerPhone(String billerPhone) {
		this.billerPhone = billerPhone;
	}

	/**
	 * @return the billerEmail
	 */
	public String getBillerEmail() {
		return billerEmail;
	}

	/**
	 * @param billerEmail the billerEmail to set
	 */
	public void setBillerEmail(String billerEmail) {
		this.billerEmail = billerEmail;
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
	 * @return the authorizationBasic
	 */
	public String getAuthorizationBasic() {
		return authorizationBasic;
	}

	/**
	 * @param authorizationBasic the authorizationBasic to set
	 */
	public void setAuthorizationBasic(String authorizationBasic) {
		this.authorizationBasic = authorizationBasic;
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
