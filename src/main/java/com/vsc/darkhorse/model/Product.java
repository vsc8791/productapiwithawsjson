package com.vsc.darkhorse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tbl_products")
public class Product {
	
	@Id
	@Column(name = "product_id")
	private Integer product_id;
	
	@Column(name = "subcategory")
	private String subcategory;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "popularity")
	private long popularity;
	
	
	public Product() {
	}


	public Product(Integer product_id, String subcategory, String title, long price, long popularity) {
		super();
		this.product_id = product_id;
		this.subcategory = subcategory;
		this.title = title;
		this.price = price;
		this.popularity = popularity;
	}


	public Integer getProduct_id() {
		return product_id;
	}


	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}


	public String getSubcategory() {
		return subcategory;
	}


	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}


	public long getPopularity() {
		return popularity;
	}


	public void setPopularity(long popularity) {
		this.popularity = popularity;
	}


	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", subcategory=" + subcategory + ", title=" + title + ", price="
				+ price + ", popularity=" + popularity + "]";
	}
	
	
	

}
