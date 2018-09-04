/**
 *
 */
package cn.dw.sw.mapper;

import java.util.List;

import cn.dw.sw.model.Product;
import cn.dw.sw.model.dto.ProductDto;

/**
 * @author aubrey
 * @date  下午4:09:10
 * mybatis接口
 */
public interface ProductMapper {
	
	public  void add(Product product);
	
	public void update(Product product);
	
	public void delete(Product product);
	
	public List<Product> query(Product product);
	
	
	public List<ProductDto> query2(Product product);
	
	

}
