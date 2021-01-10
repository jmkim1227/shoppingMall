package com.spring.admin.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.admin.goods.vo.AdminGoodsVO;
import com.spring.admin.order.vo.AdminOrderDetailVO;
import com.spring.admin.order.vo.AdminOrderVO;

@Repository
public class AdminOrderDAOImpl implements AdminOrderDAO {
	static String namespace = "com.care.mybatis.adminmapper";
	@Autowired
	SqlSession sqlSession;

	//주문 정보
	public void orderInfo(AdminOrderVO adminOrderVO) {
		sqlSession.insert(namespace+".orderInfo",adminOrderVO);
	}
	//주문 상세 정보
	public void orderInfo_Details(AdminOrderDetailVO adminOrderDetailVO) {
		sqlSession.insert(namespace+".orderInfo_Details",adminOrderDetailVO);
	}

	//주문 목록
	public List<AdminOrderVO> orderList(AdminOrderVO adminOrderVO){
		return sqlSession.selectList(namespace+".orderList",adminOrderVO);
	}
	//특정 주문 목록
	public List<AdminOrderVO> orderView(AdminOrderVO adminOrderVO){
		return sqlSession.selectList(namespace+".orderView",adminOrderVO);
	}
	//배송 상태
	public void delivery(AdminOrderVO adminOrderVO) {
		sqlSession.update(namespace+".delivery",adminOrderVO);
	}
	//상품 수량 조절
	public void changeStock(AdminGoodsVO adminGoodsVO) {
		sqlSession.update(namespace+".changeStock",adminGoodsVO);
	}
}
