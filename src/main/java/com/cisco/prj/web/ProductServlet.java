package com.cisco.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cisco.prj.dao.PersistenceException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoJdbcImpl;
import com.cisco.prj.entity.Product;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("text/html");//MIME Type
//		//response.setBufferSize(1000);
//		PrintWriter out = response.getWriter(); //Opens a character stream to browser
//		//ServletOutputStream out = response.getOutputStream(); //Byte Stream
//		out.print("<html><body>");
//		ProductDao productDao = new ProductDaoJdbcImpl();
//		List<Product> products;
//		try {
//			products = productDao.getProducts();
//			out.print("<table border='1'>");;
//			out.print("<tr><th>Id</th><th>Name</th><th>Price</th></tr>");
//			for (Product p : products) {
//				out.print("<tr>");
//				out.print("<td>" + p.getId() +"</td>");
//				out.print("<td>" + p.getName() +"</td>");
//				out.print("<td>" + p.getPrice() +"</td>");
//				out.print("</tr>");
//			}
//			out.print("</body></html>");
//		} catch (PersistenceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ProductDao productDao = new ProductDaoJdbcImpl();
		List<Product> products;
		try {
			products = productDao.getProducts();
			request.setAttribute("products", products);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product p = new Product();
		p.setName(request.getParameter("name"));
		p.setCategory(request.getParameter("category"));
		p.setPrice(Double.parseDouble(request.getParameter("price")));
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			productDao.addProduct(p);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.html");
	}

}
