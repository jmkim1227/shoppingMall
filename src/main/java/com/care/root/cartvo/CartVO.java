package com.care.root.cartvo;

import java.util.Date;

public class CartVO {
	private int cartNum;
	private String id;
	private int goodsNum;
	private int cartStock;
	private Date addDate;
	private int goodsSize;
	
	public int getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(int goodsSize) {
		this.goodsSize = goodsSize;
	}
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", id=" + id + ", goodsNum=" + goodsNum + ", cartStock=" + cartStock
				+ ", addDate=" + addDate + ", goodsSize=" + goodsSize + "]";
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
}
