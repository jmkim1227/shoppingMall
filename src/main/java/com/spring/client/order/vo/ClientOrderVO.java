package com.spring.client.order.vo;

import java.util.Date;

public class ClientOrderVO {
	private String orderId;
	private String id;
	private String orderRec;
	private String address;
	private String orderTel;
	private String orderMessage;
	private int amount;
	private String email;
	private String name;
	private Date orderDate;
	private String delivery;
	private int orderDetailsNum;
	private int goodsNum;
	private String goodsName;
	private String goodsThumbImage;
	private int goodsPrice;
	private int cartStock;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}


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
	public int getOrderDetailsNum() {
		return orderDetailsNum;
	}
	public void setOrderDetailsNum(int orderDetailsNum) {
		this.orderDetailsNum = orderDetailsNum;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsThumbImage() {
		return goodsThumbImage;
	}
	public void setGoodsThumbImage(String goodsThumbImage) {
		this.goodsThumbImage = goodsThumbImage;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	@Override
	public String toString() {
		return "ClientOrderVO [orderId=" + orderId + ", id=" + id + ", orderRec=" + orderRec + ", address=" + address
				+ ", orderTel=" + orderTel + ", amount=" + amount + ", orderDate=" + orderDate + ", delivery="
				+ delivery + ", orderDetailsNum=" + orderDetailsNum + ", goodsNum=" + goodsNum + ", goodsprice="
				+ goodsPrice + ", cartStock=" + cartStock + ", goodsName=" + goodsName + ", goodsThumbImage="
				+ goodsThumbImage + "]";
	}
	
}
