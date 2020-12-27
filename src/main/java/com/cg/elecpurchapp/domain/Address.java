package com.cg.elecpurchapp.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private int identifier;
	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	private String lState;
	private String country;
	private String postalCode;
	
	
	
public Address(String addressLineOne, String addressLineTwo, String city, String lState, String country,
			String postalCode) {
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.lState = lState;
		this.country = country;
		this.postalCode = postalCode;
	}
		public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getlState() {
		return lState;
	}
	public void setlState(String lState) {
		this.lState = lState;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
	
}
