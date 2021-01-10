package com.spring.client.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.common.member.MemberVO;
import com.spring.client.cart.service.ClientCartService;
import com.spring.client.cart.vo.CartListVO;
import com.spring.client.cart.vo.CartVO;

@Controller
@RequestMapping("member")
public class ClientCartController {

	@Autowired ClientCartService clientCartService;

	// 카트 목록
	@RequestMapping("cartList.do")
	public String getCartList(HttpSession session, Model model){

		MemberVO member = (MemberVO)session.getAttribute("clientUser");
		String id = member.getId();

		List<CartListVO> cartList = clientCartService.cartList(id);
		System.out.println("cartlistVO: "+cartList.toString());
		model.addAttribute("cartList", cartList);
		return "member/cartList";
	}

	// 카트 담기
	
	@RequestMapping(value = "/addCart.do", method = RequestMethod.POST)
	public @ResponseBody String addCart(CartVO cartVO, HttpSession session) throws Exception {
		System.out.println("카트담기");
		String result = "0";
		MemberVO member = (MemberVO)session.getAttribute("clientUser");

		if(member != null) {
			cartVO.setId(member.getId());
			clientCartService.addCart(cartVO);
			result = "1";
		}	
		return result;
	}

	// 카트 삭제
	
	@RequestMapping(value = "/deleteCart.do", method = RequestMethod.POST)
	public @ResponseBody String deleteCart(HttpSession session,
			@RequestParam(value = "chbox[]") List<String> chArr, CartVO cartVO) throws Exception {

		MemberVO member = (MemberVO)session.getAttribute("clientUser");
		String id = member.getId();

		String result = "0";
		int cartNum = 0;


		if(member != null) {
			cartVO.setId(id);

			for(String i : chArr) {   
				cartNum = Integer.parseInt(i);
				cartVO.setCartNum(cartNum);
				clientCartService.deleteCart(cartVO);
			}   
			result = "1";
		}  
		return result;  
	}

}
