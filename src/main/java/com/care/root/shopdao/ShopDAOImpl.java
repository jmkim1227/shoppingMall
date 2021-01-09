package com.care.root.shopdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.root.cartlistvo.CartListVO;
import com.care.root.cartvo.CartVO;
import com.care.root.goodsvo.GoodsVO;
import com.care.root.orderListVO.OrderListVO;
import com.care.root.orderdetailvo.OrderDetailVO;
import com.care.root.ordervo.OrderVO;

@Repository
public class ShopDAOImpl implements ShopDAO{
	static String namespace = "com.care.mybatis.myMapper";
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public GoodsVO goodsView(int goodsNum) {
		return sqlSession.selectOne(namespace+".goodsView",goodsNum);
	}
	//상품 목록
	public List<GoodsVO> list(String category){
		return sqlSession.selectList(namespace+".list",category);
	}	
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
	//주문 정보
	public void orderInfo(OrderVO orderVO) {
		sqlSession.insert(namespace+".orderInfo",orderVO);
	}
	//주문 상세 정보
	public void orderInfo_Details(OrderDetailVO orderDetailVO) {
		sqlSession.insert(namespace+".orderInfo_Details",orderDetailVO);
	}
	//카트 비우기
	public void deleteAllCart(String id) {
		sqlSession.delete(namespace+".deleteAllCart",id);
	}
	//주문 목록
	public List<OrderVO> orderList(OrderVO orderVO){
		return sqlSession.selectList(namespace+".orderList",orderVO);
	}
	//특정 주문 목록
	public List<OrderListVO> orderView(OrderVO orderVO){
		return sqlSession.selectList(namespace+".orderView",orderVO);
	}
}
