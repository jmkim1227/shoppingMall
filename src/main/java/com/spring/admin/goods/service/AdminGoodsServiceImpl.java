package com.spring.admin.goods.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.admin.goods.dao.AdminGoodsDAO;
import com.spring.admin.goods.vo.AdminGoodsVO;

@Service
public class AdminGoodsServiceImpl implements AdminGoodsService{
	@Autowired
	private AdminGoodsDAO adminGoodsDAO;
	//상품 등록
	public void goodsRegister(AdminGoodsVO AdminGoodsVO){
		adminGoodsDAO.goodsRegister(AdminGoodsVO);
	}
	//상품 목록
	public List<AdminGoodsVO> goodsList(){
		return adminGoodsDAO.goodsList();
	}
	//상품 조회
	public AdminGoodsVO goodsView(int goodsNum) {
		return adminGoodsDAO.goodsView(goodsNum);
	}

	//상품 수정
	public void goodsModify(AdminGoodsVO AdminGoodsVO) {
		adminGoodsDAO.goodsModify(AdminGoodsVO);
		System.out.println("goodsService실행");
	}
	//상품 삭제
	public void goodsDelete(int goodsNum) {
		adminGoodsDAO.goodsDelete(goodsNum);
	}
}
