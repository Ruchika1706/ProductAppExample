package com.cisco.prj.client;

import java.sql.SQLException;

import com.cisco.prj.dao.PersistenceException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoJdbcImpl;
import com.cisco.prj.entity.Product;

public class InsertProduct {

	public static void main(String[] args) {
		Product p = new Product(0,"HP Laptop",125000.00, "computer");
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			productDao.addProduct(p);
		}
		catch(PersistenceException e) {
			e.printStackTrace();
		}
		System.out.println("Added!");
		

	}

}
