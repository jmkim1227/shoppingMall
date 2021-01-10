package com.spring.admin.goods.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.spring.admin.goods.vo.AdminGoodsVO;

@Repository
public class AdminGoodsDAOImpl implements AdminGoodsDAO{
	
	static String namespace = "com.care.mybatis.adminmapper";
	@Autowired
	SqlSession sqlSession;
	
	//상품 등록
	public void goodsRegister(AdminGoodsVO AdminGoodsVO){
		try {
		sqlSession.insert(namespace+".goodsRegister",AdminGoodsVO);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//상품 목록
	public List<AdminGoodsVO> goodsList() {
		return sqlSession.selectList(namespace+".goodsList");
	}

	//상품 조회
	public AdminGoodsVO goodsView(int goodsNum) {
		return sqlSession.selectOne(namespace+".goodsView",goodsNum);
	}
	//상품 수정
	public void goodsModify(AdminGoodsVO AdminGoodsVO) {
		sqlSession.update(namespace+".goodsModify",AdminGoodsVO);	
		System.out.println("goodsDAO실행");
	}
	//상품 삭제
	public void goodsDelete(int goodsNum) {
		sqlSession.delete(namespace+".goodsDelete",goodsNum);
	}
}
