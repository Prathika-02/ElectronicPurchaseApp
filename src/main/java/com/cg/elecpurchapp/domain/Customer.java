package com.cg.elecpurchapp.domain;
/**
 * Customer POJO to carry the data related to customers.
 * @author Cheerala Prathika
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true,updatable = false)
	@NotBlank(message = "Identifier is required")
	private String identifier;
	@NotBlank(message = "Name is required")
	private String name;
	@Column
	private String email;
	@Column
	private String phone;
	
	public Customer() {
	//	super();
	}
	/**
	 * Parameterized Constructor.
	 * @param identifier
	 * @param name
	 * @param email
	 * @param phone
	 */
	public Customer(String identifier, String name, String email, String phone) {
		super();
		this.identifier = identifier;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
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
	
}
