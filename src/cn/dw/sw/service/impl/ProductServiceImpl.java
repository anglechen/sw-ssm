/**
 *
 */
package cn.dw.sw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dw.sw.dao.ProductDao;
import cn.dw.sw.dao.impl.ProductDaoImpl;
import cn.dw.sw.mapper.ProductMapper;
import cn.dw.sw.model.Product;
import cn.dw.sw.model.dto.ProductDto;
import cn.dw.sw.service.ProductService;

/**
 * @author aubrey
 * @date  上午11:22:29
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {

	/*直接使用jdbc，使用dao来实现*/
//	@Autowired //自动注入ProductDao的bean对象
//	private ProductDao productDao;
	
	/*使用mybatis来实现*/
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public void add(Product product) {
//		productDao.add(product);
		productMapper.add(product);
	}

	@Override
	public void update(Product product) {
//		productDao.update(product);
		productMapper.update(product);
	}

	@Override
	public void delete(Product product) {
//		productDao.delete(product);
		productMapper.delete(product);
	}

	@Override
	public List<Product> query(Product product) {
//		return productDao.query(product);
		return productMapper.query(product);
	}
	
	@Override
	public List<ProductDto> query2(Product product) {
//		return productDao.query(product);
		return productMapper.query2(product);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
