package com.spring.client.order.dao;

import java.util.List;

import com.spring.client.order.vo.ClientOrderDetailVO;
import com.spring.client.order.vo.ClientOrderVO;


public interface ClientOrderDAO {
	//주문 정보
	public void orderInfo(ClientOrderVO clientOrderVO);
	//주문 상세 정보
	public void orderInfo_Details(ClientOrderDetailVO clientOrderDetailVO);
	//주문 목록
	public List<ClientOrderVO> orderList(ClientOrderVO clientOrderVO);
	//특정 주문 목록
	public List<ClientOrderVO> orderView(ClientOrderVO clientOrderVO);
}
