package com.cg.elecpurchapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")

public class Payment {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String cardNumber;
	@Column
	private String cardHolderName;
	@Column
	private String expiryDate;
	@Column
	private int OTP;
	@Column
	private String paymentStatus;
	
	private String paymentMode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Payment() {
		super();
	}

	public Payment(String cardHolderName, String paymentStatus, String paymentMode) {
		super();
		this.cardHolderName = cardHolderName;
		this.paymentStatus = paymentStatus;
		this.paymentMode = paymentMode;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public String setCardHolderName(String cardHolderName) {
		return this.cardHolderName = cardHolderName;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getOTP() {
		return OTP;
	}

	public void setOTP(int oTP) {
		OTP = oTP;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Payment findByCardHolderName(String string) {
		
		return null;
	}

	public void save(Payment payment) {
		

	}

	public void getPaymentStatus(Payment payment) {

	}
}