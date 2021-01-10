package com.spring.client.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.client.order.vo.ClientOrderDetailVO;
import com.spring.client.order.vo.ClientOrderVO;

@Repository
public class ClientOrderDAOImpl implements ClientOrderDAO{
	
	static String namespace = "com.care.mybatis.myMapper";
	@Autowired
	SqlSession sqlSession;
	
	//주문 정보
	public void orderInfo(ClientOrderVO clientOrderVO) {
		sqlSession.insert(namespace+".orderInfo",clientOrderVO);
	}
	//주문 상세 정보
	public void orderInfo_Details(ClientOrderDetailVO clientOrderDetailVO) {
		sqlSession.insert(namespace+".orderInfo_Details",clientOrderDetailVO);
	}
	
	//주문 목록
	public List<ClientOrderVO> orderList(ClientOrderVO clientOrderVO){
		return sqlSession.selectList(namespace+".orderList",clientOrderVO);
	}
	//특정 주문 목록
	public List<ClientOrderVO> orderView(ClientOrderVO clientOrderVO){
		return sqlSession.selectList(namespace+".orderView",clientOrderVO);
	}
}
