package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.service.ProductService;

/**
 * Servlet implementation class ProductStoreController
 */
public class ProductStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductStoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		int PID = Integer.parseInt(request.getParameter("PID"));
		String PName = request.getParameter("PName");
		float Price = Float.parseFloat(request.getParameter("Price"));
		
		Product p = new Product();
		p.setPid(PID);
		p.setPname(PName);
		p.setPrice(Price);
		
		ProductService ps = new ProductService();
		
		String result = ps.storeProduct(p);
		
		pw.print(result);
		RequestDispatcher rd = request.getRequestDispatcher("STORE PRODUCT.html");
		rd.include(request, response);
		
	}

}