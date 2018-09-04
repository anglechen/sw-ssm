/**
 *
 */
package cn.dw.sw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.dw.sw.model.Product;
import cn.dw.sw.model.dto.ProductDto;
import cn.dw.sw.service.ProductService;

/**
 * @author aubrey
 * @date  下午3:12:12
 * 
 */
@Controller
@RequestMapping("/product") //请求路径
public class ProductController {
	
	
	@Autowired  //告诉spirng容器这里的bean需要自动注入
	private ProductService productService;
	
	@RequestMapping("/page") //请求路径,如果返回视图不需要加@ResponseBody注解
	public String page(Product product) {
		return "/product/list";
	}
	
	
	
	@RequestMapping("/add")
	@ResponseBody   //告诉spirnmvc 返回的是数据，不是视图
	public String add(Product product) {
		productService.add(product);
		JSONObject json = new JSONObject();
		json.put("result", "成功");
		return json.toJSONString();
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
		JSONObject json = new JSONObject();
		json.put("result",results);
		return json.toJSONString();
	}
	
	/*使用jackson的方式序列化数据 结合</mvc:annotation-driven>配置里面的jackson配置使用*/
	@RequestMapping("/query2")
	@ResponseBody   //告诉spirnmvc 返回的是数据，不是视图
	public List query2(Product product) {
		List results = productService.query2(product);
		return results;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
