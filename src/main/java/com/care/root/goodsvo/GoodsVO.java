package com.care.root.goodsvo;

import java.util.Date;

public class GoodsVO {
	private int goodsNum;
	private String goodsName;
	private String category;
	private int goodsPrice;
	private int goodsStock;
	private String goodsContents;
	private Date regDate;
	private int goodsSize;
	public int getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(int goodsSize) {
		this.goodsSize = goodsSize;
	}
	private String goodsImage1;
	private String goodsThumbImage;
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getGoodsThumbImage() {
		return goodsThumbImage;
	}
	public void setGoodsThumbImage(String goodsThumbImage) {
		this.goodsThumbImage = goodsThumbImage;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsStock() {
		return goodsStock;
	}
	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}
	public String getGoodsContents() {
		return goodsContents;
	}
	public void setGoodsContents(String goodsContents) {
		this.goodsContents = goodsContents;
	}
	public String getGoodsImage1() {
		return goodsImage1;
	}
	public void setGoodsImage1(String goodsImage1) {
		this.goodsImage1 = goodsImage1;
	}

}
