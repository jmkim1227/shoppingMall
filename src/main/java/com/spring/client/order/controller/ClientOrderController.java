package com.spring.client.order.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.client.cart.service.ClientCartService;
import com.spring.client.cart.vo.CartListVO;
import com.spring.client.login.service.ClientLoginService;
import com.spring.client.order.service.ClientOrderService;
import com.spring.client.order.vo.ClientOrderDetailVO;
import com.spring.client.order.vo.ClientOrderVO;
import com.spring.common.member.*;

@Controller
@RequestMapping("member")
public class ClientOrderController {
	
	@Autowired ClientLoginService clientLoginService;
	@Autowired ClientOrderService clientOrderService;
	@Autowired ClientCartService clientCartService; 

	// 주문창
	@RequestMapping(value = "/order.do", method = RequestMethod.POST)
	public String order(HttpSession session, Model model) {
		MemberVO member = (MemberVO)session.getAttribute("clientUser");
		String id = member.getId();

		List<CartListVO> cartList = clientCartService.cartList(id);

		model.addAttribute("cartList", cartList);
		return "member/order";
	}

	// 카카오 페이 결제창 컨트롤러
	@RequestMapping(value = "/kakaoPayMent.do", method = RequestMethod.POST)
	public String getKaKaoPayment(HttpSession session, ClientOrderVO clientOrderVO, ClientOrderDetailVO clientOrderDetailVO, Model model) throws Exception {

		MemberVO member = (MemberVO)session.getAttribute("clientUser");  
		String id = member.getId();

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";

		for(int i = 1; i <= 6; i ++) {
			subNum += (int)(Math.random() * 10);
		}

		String orderId = ymd + "_" + subNum;

		clientOrderVO.setOrderId(orderId);
		clientOrderVO.setId(id);

		clientOrderService.orderInfo(clientOrderVO);

		clientOrderDetailVO.setOrderId(orderId);
		
		model.addAttribute("clientOrderDetailVO", clientOrderDetailVO);
		model.addAttribute("clientOrderVO", clientOrderVO);
		//model.addAttribute("quantity", clientOrderVO.getCartStock());
		model.addAttribute("amount", clientOrderVO.getAmount());
		model.addAttribute("member", clientLoginService.user_check(new MemberVO((String)session.getAttribute("userId"))));
		
		return "member/orderList";
	}

	// 주문
	@RequestMapping(value = "/payment.do", method = RequestMethod.POST)
	public String order(HttpSession session, ClientOrderVO clientOrderVO, ClientOrderDetailVO clientOrderDetailVO, Model model) throws Exception {

		MemberVO member = (MemberVO)session.getAttribute("clientUser");  
		String id = member.getId();

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";

		for(int i = 1; i <= 6; i ++) {
			subNum += (int)(Math.random() * 10);
		}

		String orderId = ymd + "_" + subNum;

		clientOrderVO.setOrderId(orderId);
		clientOrderVO.setId(id);

		clientOrderService.orderInfo(clientOrderVO);

		clientOrderDetailVO.setOrderId(orderId);   
		clientOrderService.orderInfo_Details(clientOrderDetailVO);
		System.out.println(clientOrderVO.toString());
		clientCartService.deleteAllCart(id);
		return "redirect:/index.do";
	}

	//주문 목록
	@RequestMapping("orderList.do")
	public void getOrderList(HttpSession session, ClientOrderVO clientOrderVO, Model model) throws Exception {

		MemberVO member = (MemberVO)session.getAttribute("clientUser");
		String id = member.getId();

		clientOrderVO.setId(id);

		List<ClientOrderVO> orderList = clientOrderService.orderList(clientOrderVO);
		model.addAttribute("orderList", orderList);
	}
	// 주문 상세 목록
	@RequestMapping("/orderView.do")
	public void getOrderList(HttpSession session,
			@RequestParam("n") String orderId,
			ClientOrderVO clientOrderVO, Model model) throws Exception {

		MemberVO member = (MemberVO)session.getAttribute("clientUser");
		String id = member.getId();

		clientOrderVO.setId(id);
		clientOrderVO.setOrderId(orderId);
		System.out.println("clientOrderVO.getOrderID : "+clientOrderVO.getOrderId());

		List<ClientOrderVO> orderView = clientOrderService.orderView(clientOrderVO);
		System.out.println(orderView);
		model.addAttribute("orderView", orderView);
	}


}
