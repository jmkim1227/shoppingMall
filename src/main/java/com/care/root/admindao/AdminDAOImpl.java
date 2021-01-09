package com.care.root.admindao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.root.admindto.AdminDTO;
import com.care.root.goodsvo.GoodsVO;
import com.care.root.orderListVO.OrderListVO;
import com.care.root.ordervo.OrderVO;

@Repository
public class AdminDAOImpl {
	static String namespace = "com.care.mybatis.adminmapper";
	@Autowired
	SqlSession sqlSession;
	public AdminDTO admin_check(String adminid) {
		AdminDTO admindto = null;
		try {
			admindto = sqlSession.selectOne(namespace+".admin_check", adminid);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return admindto;
	}
	//주문 목록
	public List<OrderVO> orderList(){
		return sqlSession.selectList(namespace+".orderList");
	}
	//특정 주문 목록
	public List<OrderListVO> orderView(OrderVO orderVO){
		return sqlSession.selectList(namespace+".orderView",orderVO);
	}
	//배송 상태
	public void delivery(OrderVO orderVO) {
		sqlSession.update(namespace+".delivery",orderVO);
	}
	//상품 수량 조절
	public void changeStock(GoodsVO goodsVO) {
		sqlSession.update(namespace+".changeStock",goodsVO);
	}
}
