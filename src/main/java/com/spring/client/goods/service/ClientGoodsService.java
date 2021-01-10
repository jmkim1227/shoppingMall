package com.spring.client.goods.service;



import java.util.List;

import com.spring.client.goods.vo.ClientGoodsVO;


public interface ClientGoodsService {
	//상품 목록
	public List<ClientGoodsVO> goodsList();
	//상품 조회
	public ClientGoodsVO  goodsView(int goodsNum);
	//카테고리별 상품 목록
	public List<ClientGoodsVO> list(String category);
	
	// 메인화면 최신 등록 상품 조회
	public List<ClientGoodsVO> getNewGoodsListToMain();
}
