/**
 *
 */
package cn.dw.sw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dw.sw.model.Product;
import cn.dw.sw.service.ProductService;
import cn.dw.sw.service.impl.ProductServiceImpl;

/**
 * @author aubrey
 * @date  上午11:32:16
 * 
 */
@WebServlet("/product")
public class ProductServlet  extends HttpServlet{

	private ProductService productService  = new ProductServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String type = req.getParameter("type");
		
		Product product = new Product();
		product.setName(name);
		product.setType(type);
		productService.add(product);
		
		PrintWriter print = resp.getWriter();
		print.write("success");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	
	
	
	
	
	
	
	
	
	

}
