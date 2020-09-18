package com.vsc.darkhorse.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vsc.darkhorse.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Product> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Product> query = currentSession.createQuery("from Product", Product.class);
		List<Product> listOfProducts = query.getResultList();
		return listOfProducts;
	}

	@Override
	public List<Product> get(String firstTitle, String secondTitle, String thirdTitle, String fourthTitle) {
		List<Product> listOfProducts = new ArrayList<Product>();
		Session session = entityManager.unwrap(Session.class);
		String sqlQuery = "SELECT * FROM tbl_products p WHERE p.title LIKE '%" + firstTitle + "%' OR p.title LIKE '%"
				+ secondTitle + "%' AND p.title LIKE '%" + thirdTitle + "%' OR p.title LIKE '%"+fourthTitle+"%';";
		@SuppressWarnings("unchecked")
		Query<Product> query = session.createSQLQuery(sqlQuery);
		listOfProducts = query.list();
		return listOfProducts;
	}

	@Override
	public Product get(int product_id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Product productObj = currentSession.get(Product.class, product_id);
		return productObj;
	}

	@Override
	public Product get(String title) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<?> query = currentSession.createQuery("from Product where title = :title");
		query.setParameter("title", title);
		return (Product) query.list().get(0);
	}

	@Override
	public void save(Product product) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(product);
	}

	@Override
	public void delete(int product_id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Product productObj = currentSession.get(Product.class, product_id);
		currentSession.delete(productObj);
	}

}
