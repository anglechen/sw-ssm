/**
 *
 */
package cn.dw.sw.service;

import java.util.List;

import cn.dw.sw.model.Product;
import cn.dw.sw.model.dto.ProductDto;

/**
 * @author aubrey
 * @date  上午11:19:09
 * 
 */
public interface ProductService {
	
	public void add(Product product);
	
	public void update(Product product);
	
	public void delete(Product product);
	
	public List<Product> query(Product product);
	
	public List<ProductDto> query2(ProductDto product);
	
	public List<ProductDto> query3(ProductDto product);
	
	
	
	
	
	
	
	
	
	
	

}
