package com.care.root.goodsservice;



import java.util.List;

import com.care.root.goodsvo.GoodsVO;

public interface GoodsService {
	//상품 등록
	public void goodsRegister(GoodsVO goodsVO);
	//상품 목록
	public List<GoodsVO> goodsList();
	//상품 조회
	public GoodsVO  goodsView(int goodsNum);
	//상품 수정
	public void goodsModify(GoodsVO goodsVO);
	//상품 삭제
	public void goodsDelete(int goodsNum);
}
