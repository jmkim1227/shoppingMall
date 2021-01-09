package com.care.root.goodsdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.care.root.goodsvo.GoodsVO;

@Repository
public class GoodsDAOImpl implements GoodsDAO{
	static String namespace = "com.care.mybatis.myMapper";
	@Autowired
	SqlSession sqlSession;
	//상품 등록
	public void goodsRegister(GoodsVO goodsVO){
		try {
		sqlSession.insert(namespace+".goodsRegister",goodsVO);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//상품 목록
	public List<GoodsVO> goodsList() {
		return sqlSession.selectList(namespace+".goodsList");
	}

	//상품 조회
	public GoodsVO goodsView(int goodsNum) {
		return sqlSession.selectOne(namespace+".goodsView",goodsNum);
	}
	//상품 수정
	public void goodsModify(GoodsVO goodsVO) {
		sqlSession.update(namespace+".goodsModify",goodsVO);	
		System.out.println("goodsDAO실행");
	}
	//상품 삭제
	public void goodsDelete(int goodsNum) {
		sqlSession.delete(namespace+".goodsDelete",goodsNum);
	}
}
