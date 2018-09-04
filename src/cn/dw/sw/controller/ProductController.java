/**
 *
 */
package cn.dw.sw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dw.sw.model.Product;
import cn.dw.sw.service.ProductService;

/**
 * @author aubrey
 * @date  下午3:12:12
 * 
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired  //告诉spirng容器这里的bean需要自动注入
	private ProductService productService;
	
	@RequestMapping("/page")
	public String page(Product product) {
		return "/product/list";
	}
	
	
	
	@RequestMapping("/add")
	@ResponseBody   //告诉spirnmvc 返回的是数据，不是视图
	public String add(Product product) {
		productService.add(product);
		return "success";
	}
	
	@RequestMapping("/update")
	@ResponseBody   //告诉spirnmvc 返回的是数据，不是视图
	public String update(Product product) {
		productService.update(product);
		return "success";
	}
	
	@RequestMapping("/delete")
	@ResponseBody   //告诉spirnmvc 返回的是数据，不是视图
	public String delete(Product product) {
		productService.delete(product);
		return "success";
	}
	
	
	@RequestMapping("/query")
	@ResponseBody   //告诉spirnmvc 返回的是数据，不是视图
	public String query(Product product) {
		List<Product> results = productService.query(product);
		return results.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
