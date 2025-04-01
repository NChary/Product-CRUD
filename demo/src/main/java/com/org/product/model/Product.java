package com.org.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="product")
public class Product {

	@Id  // Primary
	@Column(name="id")
	private int id;
	
	@Column(name="pid")
	private int pid;

	@NotNull(message = "Product Name is mandatory")
	@Column(name="pname")
	private String pname;
	
	@NotNull(message="Category is mandatory")
	@Column(name="category")
	private String category;
	
	@Column(name="man_date")
	private String manDate;
	
	@Column(name="exp_date")
	private String expDate;
	
	@Column(name="price")
	private double price;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getManDate() {
		return manDate;
	}
	public void setManDate(String manDate) {
		this.manDate = manDate;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
