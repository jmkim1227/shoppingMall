package com.spring.client.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.client.cart.vo.CartListVO;
import com.spring.client.cart.vo.CartVO;

@Repository
public class CartDAOImpl implements CartDAO {
	
	static String namespace = "com.care.mybatis.myMapper";
	@Autowired
	SqlSession sqlSession;
	
	//카트에 담기
	public void addCart(CartVO cartVO) {
		sqlSession.insert(namespace+".addCart",cartVO);
	}
	//카트 목록
	public List<CartListVO> cartList(String id){
		return sqlSession.selectList(namespace+".cartList",id);
	}
	//카트 삭제
	public void deleteCart(CartVO cartVO) {
		sqlSession.delete(namespace+".deleteCart",cartVO);
	}
	//카트 비우기
	public void deleteAllCart(String id) {
		sqlSession.delete(namespace+".deleteAllCart",id);
	}
}
