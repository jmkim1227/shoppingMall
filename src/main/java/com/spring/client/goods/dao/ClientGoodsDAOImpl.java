package com.spring.client.goods.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.spring.client.goods.vo.ClientGoodsVO;


@Repository
public class ClientGoodsDAOImpl implements ClientGoodsDAO{
	static String namespace = "com.care.mybatis.myMapper";
	@Autowired
	SqlSession sqlSession;

	//상품 목록
	public List<ClientGoodsVO> goodsList() {
		return sqlSession.selectList(namespace+".goodsList");
	}

	//상품 조회
	public ClientGoodsVO goodsView(int goodsNum) {
		return sqlSession.selectOne(namespace+".goodsView",goodsNum);
	}

	//카테고리별 상품 목록
	public List<ClientGoodsVO> list(String category){
		return sqlSession.selectList(namespace+".list",category);
	}

	// 메인화면 최신 등록 상품 조회
	public List<ClientGoodsVO> getNewGoodsListToMain() {
		return sqlSession.selectList(namespace+".newGoodsList");
	}
}
