package com.vsc.darkhorse.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsc.darkhorse.dao.ProductDAO;
import com.vsc.darkhorse.model.Product;
import com.vsc.darkhorse.model.Title;
import com.vsc.darkhorse.utils.JSONModelMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	
	@Transactional
	@Override
	public List<Product> get() {
		return productDAO.get();
	}
	
	@Transactional
	@Override
	public List<Product> get(Title title) {
		Title titleObj = new Title();
		String firstTitle = title.getFirstTitle();
		String secondTitle = title.getSecondTitle();
		String thirdTitle = title.getThirdTitle();
		String fourthTitle = title.getFourthTitle();
		if (firstTitle.equals(null)) {
			titleObj.setFirstTitle("");
		} else {
			titleObj.setFirstTitle(title.getFirstTitle());
		}

		if (secondTitle.equals(null)) {
			titleObj.setFirstTitle("");
		} else {
			titleObj.setFirstTitle(title.getSecondTitle());
		}

		if (thirdTitle.equals(null)) {
			titleObj.setFirstTitle("");
		} else {
			titleObj.setFirstTitle(title.getThirdTitle());
		}

		if (fourthTitle.equals(null)) {
			titleObj.setFirstTitle("");
		} else {
			titleObj.setFirstTitle(title.getFourthTitle());
		}
		return productDAO.get(firstTitle, secondTitle, thirdTitle, fourthTitle);
	}


	@Transactional
	@Override
	public Product get(int product_id) {
		return productDAO.get(product_id);
	}
	
	@Transactional
	@Override
	public Product get(String title) {
		return productDAO.get(title);
	}

	@Transactional
	@Override
	public void save(Product product) {
		productDAO.save(product);
		
	}

	@Transactional 
	@Override
	public void delete(int product_id) {
		 productDAO.delete(product_id); 	
	}

	@Transactional
	@Override
	public Product update(Product productObj, int product_id) {
		Product product = productDAO.get(product_id);
		product.setPopularity(productObj.getPopularity());
		product.setPrice(productObj.getPrice());
		product.setSubcategory(productObj.getSubcategory());
		product.setTitle(productObj.getTitle());
		productDAO.save(product);
		return productDAO.get(product_id);
	}

	@Transactional
	@Override
	public String loadJSONFile() {
		try {
			List<Product> loadAllProducts = JSONModelMapper.getProductObject();
			for (int index = 0; index < loadAllProducts.size(); index++) {
				productDAO.save(loadAllProducts.get(index));
			}
			return "<h1>JSON File Loaded Succesfully</h1>";
		} catch (Exception e) {
			return "<h1>JSON File Not Loaded Succesfully</h1>";
		}
	}

	
	
}
