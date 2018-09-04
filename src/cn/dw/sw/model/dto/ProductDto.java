/**
 *
 */
package cn.dw.sw.model.dto;

import cn.dw.sw.model.Product;

/**
 * @author aubrey
 * @date  下午5:31:57
 * 
 */
public class ProductDto extends Product {
	private String statusName;

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
	
}
