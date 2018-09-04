/**
 *
 */
package cn.dw.sw.dao;

import java.util.List;

import cn.dw.sw.model.Product;

/**
 * @author aubrey
 * @date  上午10:09:54
 * 
 */
public interface ProductDao {
	
	public  void add(Product product);
	
	public void update(Product product);
	
	public void delete(Product product);
	
	public List<Product> query(Product product);
	
	
	
	
	
	
	

}
