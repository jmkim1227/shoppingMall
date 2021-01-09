package com.care.root.adminservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.admindao.AdminDAOImpl;
import com.care.root.admindto.AdminDTO;
import com.care.root.goodsvo.GoodsVO;
import com.care.root.orderListVO.OrderListVO;
import com.care.root.ordervo.OrderVO;


@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDAOImpl admindao;
	public int admin_check(HttpServletRequest request, Model model) {
		String adminid = request.getParameter("adminid");
		String pwd = request.getParameter("pwd");
		AdminDTO admindto = admindao.admin_check(adminid);
		String message="아이디 또는 비밀번호를 확인해주세요.";
		System.out.println("dto : "+admindto);
		if(admindto != null) {
			if(admindto.getPwd().equals(pwd)) {
				HttpSession s = request.getSession();
				s.setAttribute("adminid", admindto.getAdminid());
				return 1;
			}else {
				System.out.println("비밀번호 틀림");
				HttpSession s = request.getSession();
				s.setAttribute("message",message);				
				return 0;
			}
		}else {
			System.out.println("로그인 실패");
			HttpSession s = request.getSession();
			s.setAttribute("message",message);			
			return 0;
		}

	}
	//주문 목록
	public List<OrderVO> orderList(){
		return admindao.orderList();
	}
	//특정 주문 목록
	public List<OrderListVO> orderView(OrderVO orderVO){
		return admindao.orderView(orderVO);
	}
	//배송 상태
	public void delivery(OrderVO orderVO) {
		admindao.delivery(orderVO);
	}
	//상품 수량 조절
	public void changeStock(GoodsVO goodsVO) {
		admindao.changeStock(goodsVO);
	}
}
