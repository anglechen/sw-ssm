/**
 *
 */
package cn.dw.sw.model;

import java.util.Date;

/**
 * @author aubrey
 * @date  上午10:01:05
 * 
 */
public class Product {
	
	private Integer id;
	
	private String name;
	
	private String type;
	
	private String seria;
	
	private Date produceDate;
	
	private Integer status;
	
	private Float  prices;
	
	private String userPeople;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSeria() {
		return seria;
	}

	public void setSeria(String seria) {
		this.seria = seria;
	}

	public Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Float getPrices() {
		return prices;
	}

	public void setPrices(Float prices) {
		this.prices = prices;
	}

	public String getUserPeople() {
		return userPeople;
	}

	public void setUserPeople(String userPeople) {
		this.userPeople = userPeople;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", seria=" + seria + ", produceDate="
				+ produceDate + ", status=" + status + ", prices=" + prices + ", userPeople=" + userPeople + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
