package com.care.root.replyvo;

import java.util.Date;

public class ReplyVO {
	private int goodsNum;
	private String id;
	private int repNum;
	private String repContents;
	private Date repDate;
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRepNum() {
		return repNum;
	}
	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}
	public String getRepContents() {
		return repContents;
	}
	public void setRepContents(String repContents) {
		this.repContents = repContents;
	}
	public Date getRepDate() {
		return repDate;
	}
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
}
