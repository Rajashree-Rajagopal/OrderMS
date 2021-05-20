package com.infy.OrderMS.DTO;

import com.infy.OrderMS.entity.Order;
import com.infy.OrderMS.entity.ProductsOrdered;

public class ProductsOrderedDTO {
	private Integer orderId;
	private Integer prodId;
	private Integer sellerId;
	private Integer quantity;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

public static ProductsOrderedDTO valueOf(ProductsOrdered productsordered) {
	ProductsOrderedDTO pd = new ProductsOrderedDTO();
	pd.setOrderId(productsordered.getOrderId());
	pd.setProdId(productsordered.getProdId());
	pd.setSellerId(productsordered.getSellerId());
	pd.setQuantity(productsordered.getQuantity());
	return pd;
}

}
