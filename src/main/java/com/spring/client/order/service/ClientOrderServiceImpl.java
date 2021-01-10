package com.spring.client.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.order.dao.ClientOrderDAO;
import com.spring.client.order.vo.ClientOrderDetailVO;
import com.spring.client.order.vo.ClientOrderVO;


@Service
public class ClientOrderServiceImpl implements ClientOrderService {
	
	@Autowired ClientOrderDAO clientOrderDAO;
	
	//주문 정보
	public void orderInfo(ClientOrderVO clientOrderVO) {
		clientOrderDAO.orderInfo(clientOrderVO);
	}
	//주문 상세 정보
	public void orderInfo_Details(ClientOrderDetailVO clientOrderDetailVO) {
		clientOrderDAO.orderInfo_Details(clientOrderDetailVO);
	}
	//주문 목록
	public List<ClientOrderVO> orderList(ClientOrderVO clientOrderVO){
		return clientOrderDAO.orderList(clientOrderVO);
	}
	//특정 주문 목록
	public List<ClientOrderVO> orderView(ClientOrderVO clientOrderVO){
		return clientOrderDAO.orderView(clientOrderVO);
	}
}
