package kh.com.kshrd.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

@Entity
@Table(name="bills")
public class Bills extends ResourceSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6471595557319732624L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="billing_id")
	private Long biilingId;
	
	@Column(name="customer_id")
	private Long customerId;
	
	@Column(name="expiry_date")
	private Date expiryDate;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="created_date")
	private Date createdDate;
	
}
