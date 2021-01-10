package com.spring.admin.goods.service;

import java.util.List;

import com.spring.admin.goods.vo.AdminGoodsVO;

public interface AdminGoodsService {
	//상품 등록
	public void goodsRegister(AdminGoodsVO goodsVO);
	//상품 목록
	public List<AdminGoodsVO> goodsList();
	//상품 조회
	public AdminGoodsVO goodsView(int goodsNum);
	//상품 수정
	public void goodsModify(AdminGoodsVO goodsVO);
	//상품 삭제
	public void goodsDelete(int goodsNum);
}
