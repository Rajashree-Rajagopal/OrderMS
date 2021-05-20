package com.infy.OrderMS.entity;
import java.io.Serializable;

public class CompositePK implements Serializable {
	private static final long serialVersionUID = 1L;
	private int orderId;
	private int prodId;
	
	public CompositePK() {
	}

	public CompositePK(int orderId, int prodId) {
		this.orderId = orderId;
		this.prodId = prodId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	
	

}
