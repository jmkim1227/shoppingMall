package com.spring.admin.goods.dao;

import java.util.List;

import com.spring.admin.goods.vo.AdminGoodsVO;


public interface AdminGoodsDAO {
	//상품 등록
	public void goodsRegister(AdminGoodsVO AdminGoodsVO);
	// 상품 목록
	public List<AdminGoodsVO> goodsList();
	// 상품 조회
	public AdminGoodsVO goodsView(int goodsNum);
	//상품 수정
	public void goodsModify(AdminGoodsVO AdminGoodsVO);
	//상품 삭제
	public void goodsDelete(int goodsNum);
}
