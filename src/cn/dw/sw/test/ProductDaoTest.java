/**
 *
 */
package cn.dw.sw.test;

import java.util.List;

import javax.swing.event.ListSelectionEvent;

import cn.dw.sw.dao.ProductDao;
import cn.dw.sw.dao.impl.ProductDaoImpl;
import cn.dw.sw.model.Product;

/**
 * @author aubrey
 * @date  上午10:33:19
 * 
 */
public class ProductDaoTest {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoImpl();
		Product product = new Product();
		product.setName("test");
//		productDao.add(product);
		List<Product> results =   productDao.query(product);
		
		for(Product p : results) {
			System.out.println(p);
		}
		System.out.println("执行成功");
		
		
		
		
		
	}
}
