package com.example.demo.entity;


import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="prices")
public class Task implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	private Integer brand_id;
	private LocalDateTime  start_Date;
	private LocalDateTime end_Date;
	private Integer price_List;
	private Integer product_id;
	private Integer priority;
	private float price;
	private String curr;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getBrand_id() {
		return brand_id;
	}


	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}


	public LocalDateTime  getStart_Date() {
		return start_Date;
	}


	public void setStart_Date(LocalDateTime  start_Date) {
		this.start_Date = start_Date;
	}


	public LocalDateTime getEnd_Date() {
		return end_Date;
	}


	public void setEnd_Date(LocalDateTime end_Date) {
		this.end_Date = end_Date;
	}


	public Integer getPrice_List() {
		return price_List;
	}


	public void setPrice_List(Integer price_List) {
		this.price_List = price_List;
	}


	public Integer getProduct_id() {
		return product_id;
	}


	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getCurr() {
		return curr;
	}


	public void setCurr(String curr) {
		this.curr = curr;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
