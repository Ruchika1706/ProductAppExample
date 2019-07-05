package com.cisco.prj.client;

import java.sql.SQLException;
import java.util.List;

import com.cisco.prj.dao.PersistenceException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoJdbcImpl;
import com.cisco.prj.entity.Product;

public class FetchProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDao productDao = new ProductDaoJdbcImpl();
			List<Product> products;
			try {
				products = productDao.getProducts();
				for (Product p : products) {
					System.out.println(p);
				}
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 

	}
