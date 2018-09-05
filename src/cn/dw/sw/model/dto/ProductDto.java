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
	
	/*开始的页数*/
	private Integer startPage;
	
	/*每页多少条记录*/
	private Integer rowCount;

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	
	
	
}
