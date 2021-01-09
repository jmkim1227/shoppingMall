package com.care.root.goodsservice;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.care.root.goodsdao.GoodsDAO;
import com.care.root.goodsvo.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Inject
	GoodsDAO goodsdao;
	//상품 등록
	public void goodsRegister(GoodsVO goodsVO){
		goodsdao.goodsRegister(goodsVO);
	}
	//상품 목록
	public List<GoodsVO> goodsList(){
		return goodsdao.goodsList();
	}
	//상품 조회
	public GoodsVO  goodsView(int goodsNum) {
		return goodsdao.goodsView(goodsNum);
	}

	//상품 수정
	public void goodsModify(GoodsVO goodsVO) {
		goodsdao.goodsModify(goodsVO);
		System.out.println("goodsService실행");
	}
	//상품 삭제
	public void goodsDelete(int goodsNum) {
		goodsdao.goodsDelete(goodsNum);
	}
}
