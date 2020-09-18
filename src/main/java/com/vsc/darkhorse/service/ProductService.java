package com.vsc.darkhorse.service;

import java.util.List;

import com.vsc.darkhorse.model.Product;
import com.vsc.darkhorse.model.Title;

public interface ProductService {

	List<Product> get();
	
	String loadJSONFile();

	Product get(int product_id);
	
	Product get(String title);
	
	List<Product> get(Title title);

	void save(Product product);

	void delete(int product_id);
	
	Product update(Product productObj,int product_id);
	

}
