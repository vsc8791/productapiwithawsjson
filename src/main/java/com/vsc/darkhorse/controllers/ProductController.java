package com.vsc.darkhorse.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vsc.darkhorse.model.Product;
import com.vsc.darkhorse.model.Title;
import com.vsc.darkhorse.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/product")
	public List<Product> get() {
		return productService.get();
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public List<Product> get(@RequestBody Title title) {
		return productService.get(title);
	}

	@PostMapping("/product")
	public Product save(@RequestBody Product productObj) {
		productService.save(productObj);
		return productObj;
	}

	@GetMapping("/load")
	public String loadJSON() {
		return productService.loadJSONFile();
	}

	@GetMapping("/product/{id}")
	public Product getById(@PathVariable(value = "id") int product_id) {
		return productService.get(product_id);
	}

	@GetMapping("/product/title/{title}")
	public Product getByTitle(@PathVariable(value = "title") String title) {
		return productService.get(title);
	}

	@PutMapping("/product/update/{id}")
	public Product update(@PathVariable(value = "id") int product_id, @Valid @RequestBody Product productObj) {
		return productService.update(productObj, product_id);
	}

	@DeleteMapping("/product/{id}")
	public String delete(@PathVariable(value = "id") int product_id) {
		productService.delete(product_id);
		return "<h1>Product has been deleted with ID :" + product_id + "</h1>";
	}
}