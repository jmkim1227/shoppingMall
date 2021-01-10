package com.spring.client.goods.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.goods.dao.ClientGoodsDAO;
import com.spring.client.goods.vo.ClientGoodsVO;


@Service
public class ClientGoodsServiceImpl implements ClientGoodsService{
	@Autowired
	private ClientGoodsDAO clientGoodsDAO;

	//상품 목록
	public List<ClientGoodsVO> goodsList(){
		return clientGoodsDAO.goodsList();
	}
	//상품 조회
	public ClientGoodsVO  goodsView(int goodsNum) {
		return clientGoodsDAO.goodsView(goodsNum);
	}

	//카테고리별 상품 목록
	public List<ClientGoodsVO> list(String category){
		return clientGoodsDAO.list(category);
	}

	// 메인화면 최신 등록 상품 조회
	public List<ClientGoodsVO> getNewGoodsListToMain() {
		return clientGoodsDAO.getNewGoodsListToMain();
	}
}
