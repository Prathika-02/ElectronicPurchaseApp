package com.cg.elecpurchapp.domain;
import javax.persistence.AttributeOverrides;
/**
 * Customer POJO to carry the data related to customers.
 * @author Cheerala Prathika
 *
 */
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@NotBlank(message = "Identifier is required")
	@Column(unique = true,updatable = false)
	@Size(min=3, max=5,message = "Size must be between 3 to 5 characters")
	private String identifier;
	@Column
	@NotBlank(message = "Name is required")
	private String name;
	@Column
	@NotBlank(message = "Email id can't be blank")
	private String email;
	@Column
	@NotBlank(message = "Phone No is required")
	private String phone;
	@NotBlank(message = "Address 1 can't be blank")
	private String addressLineOne;
	@NotBlank(message = "Address 2 is required")
	private String addressLineTwo;
	@NotBlank(message = "City is required")
	private String city;
	@NotBlank(message = "State can't be blank")
	private String lState;
	@NotBlank(message = "Country is required")
	private String country;
	@NotBlank(message = "Postal Code can't be blank")
	private String postalCode;
	
	public Customer() {
	
	}
	/**
	 * Parameterized Constructor.
	 * @param identifier
	 * @param name
	 * @param email
	 * @param phone
	 */
	
	public String getIdentifier() {
		return identifier;
	}
	public Customer(
			@NotBlank(message = "Identifier is required") @Size(min = 3, max = 5, message = "Size must be between 3 to 5 characters") String identifier,
			@NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Email id is required") String email,
			@NotBlank(message = "Phone No is required") String phone,
			@NotBlank(message = "Address 1 is required") String addressLineOne,
			@NotBlank(message = "Address 2 is required") String addressLineTwo,
			@NotBlank(message = "City is required") String city, @NotBlank(message = "State is required") String lState,
			@NotBlank(message = "Country is required") String country,
			@NotBlank(message = "Postal Code is required") String postalCode) {
		super();
		this.identifier = identifier;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.lState = lState;
		this.country = country;
		this.postalCode = postalCode;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
