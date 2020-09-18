package com.vsc.darkhorse.dao;

import java.util.List;

import com.vsc.darkhorse.model.Product;

public interface ProductDAO {
	
	List<Product> get();
	
	List<Product> get(String firstTitle , String secondTitle , String thirdTitle ,  String fourthTitle);
	
	Product get(int product_id);
	
	void save(Product product);
	
	void delete(int product_id);
	
	Product get(String title);
	
	

} 
