package com.cisco.prj.dao;

import java.util.List;

import com.cisco.prj.entity.Product;

public interface ProductDao {
	void addProduct(Product p) throws PersistenceException ;
	List<Product> getProducts() throws PersistenceException ;
}