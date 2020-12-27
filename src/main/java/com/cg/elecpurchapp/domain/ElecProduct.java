package com.cg.elecpurchapp.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is a ElecProduct class which has fields for product details.
 * This ElecProduct entity creates as elecProduct table in database
 * @author Shivani Pakde
 *
 */

@Entity
@Table(name = "elecProducts")
public class ElecProduct {
  
	/**
	 * creating Integer  variable productId
	 */
	@Id
	@GeneratedValue
	private int productId;

	/**
	 * creating String  variable name
	 */
	@Column
	private String name;

	/**
	 * creating Double  variable price
	 */
	@Column
	private double price;

	/**
	 * creating String variable image
	 */
	@Column
	private String image;
	/**
	 * creating LocalDate  variable createDate
	 */
	@Column
	private LocalDate createDate;
	
	
	/**
	 * creating non-parameterized constructor 
	 */
	public ElecProduct() {
	
	}
	/**
	 * creating getters and setters for all variables 
	 */
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * creating a parameterized constructor to set the values passed as parameters to respective instance variables while creating constructor object */
	public ElecProduct(String name, double price, String image, LocalDate createDate) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
		this.createDate = createDate;
	}
	
}
