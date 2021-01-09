package com.care.root.ordervo;

import java.util.Date;

public class OrderVO {
	private String orderId;
	private String id;
	private String orderRec;
	private String address;
	private String orderTel;
	private int amount;
	private String email;
	private String orderMessage;
	private String name;
	private String goodsName;
	private String delivery;
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrderMessage() {
		return orderMessage;
	}
	public void setOrderMessage(String orderMessage) {
		this.orderMessage = orderMessage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Date orderDate;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderRec() {
		return orderRec;
	}
	public void setOrderRec(String orderRec) {
		this.orderRec = orderRec;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderTel() {
		return orderTel;
	}
	public void setOrderTel(String orderTel) {
		this.orderTel = orderTel;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "OrderVO [orderId=" + orderId + ", id=" + id + ", orderRec=" + orderRec + ", address=" + address
				+ ", orderTel=" + orderTel + ", amount=" + amount + ", email=" + email + ", orderMessage="
				+ orderMessage + ", name=" + name + ", goodsName=" + goodsName + ", orderDate=" + orderDate + "]";
	}
}
