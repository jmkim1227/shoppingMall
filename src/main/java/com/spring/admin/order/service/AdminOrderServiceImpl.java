package com.spring.admin.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.admin.goods.vo.AdminGoodsVO;
import com.spring.admin.order.dao.AdminOrderDAO;
import com.spring.admin.order.vo.AdminOrderDetailVO;
import com.spring.admin.order.vo.AdminOrderVO;


@Service
public class AdminOrderServiceImpl implements AdminOrderService {
	@Autowired AdminOrderDAO adminOrderDAO;

	//주문 정보
	public void orderInfo(AdminOrderVO adminOrderVO) {
		adminOrderDAO.orderInfo(adminOrderVO);
	}
	//주문 상세 정보
	public void orderInfo_Details(AdminOrderDetailVO adminOrderDetailVO) {
		adminOrderDAO.orderInfo_Details(adminOrderDetailVO);
	}
	//주문 목록
	public List<AdminOrderVO> orderList(AdminOrderVO adminOrderVO){
		return adminOrderDAO.orderList(adminOrderVO);
	}
	//특정 주문 목록
	public List<AdminOrderVO> orderView(AdminOrderVO adminOrderVO){
		return adminOrderDAO.orderView(adminOrderVO);
	}
	//배송 상태
	public void delivery(AdminOrderVO adminOrderVO) {
		adminOrderDAO.delivery(adminOrderVO);
	}
	//상품 수량 조절
	public void changeStock(AdminGoodsVO adminGoodsVO) {
		adminOrderDAO.changeStock(adminGoodsVO);
	}
}
