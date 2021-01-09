package com.care.root.orderListVO;

import java.util.Date;

public class OrderListVO {
	private String orderId;
	private String id;
	private String orderRec;
	private String address;
	private String orderTel;
	private int amount;
	private Date orderDate;
	private int orderDetailsNum;
	private int goodsNum;
	private int cartStock;
	private String goodsName;
	private String goodsThumbImage;
	private String delivery;
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	private int goodsPrice;
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
	
}
