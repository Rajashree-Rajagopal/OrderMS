package com.infy.OrderMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CompositePK.class)
@Table(name="orderedproductsdetails")
public class ProductsOrdered {
		@Id
		@Column(name = "order_id", nullable = false)
		private Integer orderId;
		@Id
		@Column(name = "prod_id")
		private Integer prodId;
		@Column(name = "seller_id")
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
	}
