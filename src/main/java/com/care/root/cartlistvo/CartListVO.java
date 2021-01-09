package com.care.root.cartlistvo;

import java.util.Date;

public class CartListVO {
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
	private int num;
	private String goodsName;
	private int goodsPrice;
	private String goodsThumbImage;
	
	public int getNum() {
		return num;
	}
	@Override
	public String toString() {
		return "CartListVO [cartNum=" + cartNum + ", id=" + id + ", goodsNum=" + goodsNum + ", cartStock=" + cartStock
				+ ", addDate=" + addDate + ", goodsSize=" + goodsSize + ", num=" + num + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", goodsThumbImage=" + goodsThumbImage + "]";
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsThumbImage() {
		return goodsThumbImage;
	}
	public void setGoodsThumbImage(String goodsThumbImage) {
		this.goodsThumbImage = goodsThumbImage;
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
