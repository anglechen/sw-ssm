/**
 *
 */
package cn.dw.sw.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import cn.dw.sw.dao.ProductDao;
import cn.dw.sw.model.Product;

/**
 * @author aubrey
 * @date  上午10:16:27
 * 
 */
public class ProductDaoImpl implements ProductDao {

	static {
		/*1.加载驱动*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private final String url = "jdbc:mysql://localhost:3306/sw-ssm?characterEncoding=utf8";
	private final String user = "root";
	private final String password = "123456";
	
	
	@Override
	public void add(Product product) {
		String sql = "insert into product(name) values('"+ product.getName() +"')";
		Connection  conn = null;
		try {
			conn =   DriverManager.getConnection(url, user, password);
			Statement stateMent = conn.createStatement();
			stateMent.execute(sql);
			stateMent.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(Product product) {
		
	}

	@Override
	public void delete(Product product) {
		
	}

	@Override
	public List<Product> query(Product product) {
//		最后的返回结果集
		List<Product> results = new ArrayList<>();
		String sql = "select id, name,type,seria,produce_date, "
				+ "status , prices ,user_people as userPeople from product";
		Connection  conn = null;
		try {
			conn =   DriverManager.getConnection(url, user, password);
			Statement stateMent = conn.createStatement();
			ResultSet resultSet = stateMent.executeQuery(sql);
//			根据结果集获取表的元数据信息，（表的字段名称，列总数）
			ResultSetMetaData metaData = resultSet.getMetaData();
			int count = metaData.getColumnCount();//获取表一共有多少列
//			遍历每一行数据
			while(resultSet.next()) {
				Map map = new HashMap<>();
//				遍历每一列数据
				for(int i = 1 ; i<= count; i++) {
					System.out.println(metaData.getColumnName(i) +":" 
						+  resultSet.getString(i));
					map.put(metaData.getColumnLabel(i), resultSet.getString(i));
					
				}
				Product temp = new Product();
				try {
//					把map转换为bean
					BeanUtils.populate(temp, map);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				
				results.add(temp);
			}
			
			
			
			stateMent.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	
	
	
	
	
	
	
	

}
