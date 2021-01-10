package com.spring.admin.order.dao;

import java.util.List;

import com.spring.admin.goods.vo.AdminGoodsVO;
import com.spring.admin.order.vo.AdminOrderDetailVO;
import com.spring.admin.order.vo.AdminOrderVO;


public interface AdminOrderDAO {
	//주문 정보
	public void orderInfo(AdminOrderVO adminOrderVO);
	//주문 상세 정보
	public void orderInfo_Details(AdminOrderDetailVO adminOrderDetailVO);
	//주문 목록
	public List<AdminOrderVO> orderList(AdminOrderVO adminOrderVO);
	//특정 주문 목록
	public List<AdminOrderVO> orderView(AdminOrderVO adminOrderVO);

	//배송 상태
	public void delivery(AdminOrderVO adminOrderVO);
	//상품 수량 조절
	public void changeStock(AdminGoodsVO adminGoodsVO);
}
