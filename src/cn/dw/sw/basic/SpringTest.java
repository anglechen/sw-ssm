/**
 *
 */
package cn.dw.sw.basic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dw.sw.dao.ProductDao;
import cn.dw.sw.model.Product;
import cn.dw.sw.service.ProductService;

/**
 * @author aubrey
 * @date  下午2:49:04
 * 
 */
public class SpringTest {
	public static void main(String[] args) {
		
		BeanFactory beanFacotory = new ClassPathXmlApplicationContext("classpath:application.xml");
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
		
		ProductService productService = (ProductService) beanFacotory.getBean("productServiceImpl");
		
		ProductDao productDao = (ProductDao) beanFacotory.getBean("productDaoImpl");
		System.out.println(productDao);
		Product product = new Product();
		product.setName("笔记本电脑");
		productService.add(product);
		System.out.println("success");
		
		
		
		
		
		
		
		
		
		
	}
}
