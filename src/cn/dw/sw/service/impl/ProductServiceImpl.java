/**
 *
 */
package cn.dw.sw.service.impl;

import java.util.List;

import cn.dw.sw.dao.ProductDao;
import cn.dw.sw.dao.impl.ProductDaoImpl;
import cn.dw.sw.model.Product;
import cn.dw.sw.service.ProductService;

/**
 * @author aubrey
 * @date  上午11:22:29
 * 
 */
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao = new ProductDaoImpl();
	
	@Override
	public void add(Product product) {
		productDao.add(product);
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	@Override
	public void delete(Product product) {
		productDao.delete(product);
	}

	@Override
	public List<Product> query(Product product) {
		return productDao.query(product);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
