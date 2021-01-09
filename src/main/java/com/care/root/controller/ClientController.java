package com.care.root.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.clientloginvo.ClientLoginVO;
import com.care.root.membervo.MemberVO;
import com.care.root.orderListVO.OrderListVO;
import com.care.root.orderdetailvo.OrderDetailVO;
import com.care.root.ordervo.OrderVO;
import com.care.root.shopservice.ShopService;
import com.care.root.cartlistvo.CartListVO;
import com.care.root.cartvo.CartVO;
import com.care.root.clientloginservice.ClientLoginService;

@Controller
@RequestMapping("member")
public class ClientController {
	@Autowired
    BCryptPasswordEncoder passEncoder;  // 비밀번호 암호화

	@Autowired
    private ClientLoginService clientLoginService;
    @Autowired ShopService shopService;
    
    @PostMapping("user_check")
    public String user_check(MemberVO memberVO, HttpServletRequest request, RedirectAttributes rttr) 
                                                                                    throws Exception{

    	MemberVO member = clientLoginService.user_check(memberVO);
        HttpSession session = request.getSession();


        if(member != null && passEncoder.matches(memberVO.getPwd(), member.getPwd())) {
         session.setAttribute("clientUser", member);
        } else {
         session.setAttribute("clientUser", null);
         rttr.addFlashAttribute("clientmsg", false);
         System.out.println("로그인 실패");
         return "redirect:/member/clientLogin";
        }
        System.out.println("로그인 성공");
        return "redirect:/";

    }
    @RequestMapping("clientLogin")
    public String clientLogin() {
        return "member/clientLogin";
    }

    @RequestMapping("clientlogout")
    public String clientLogout(HttpSession session) throws Exception{
        clientLoginService.clientLogout(session);
        return "redirect:/";
    }
	@RequestMapping("mypage")
	public String mypage() {
		return "member/mypage";
	}
	@RequestMapping("signup")
	public String signup() {
		return "member/signup";
	}
	@RequestMapping("customerservice")
	public String customerservice() {
		return "member/customerservice";
	}
	@RequestMapping("basket")
	public String basket() {
		return "member/basket";
	}
	
	// 카트 담기
	@ResponseBody
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public int addCart(CartVO cartVO, HttpSession session) throws Exception {
		System.out.println("카트담기");
	 int result = 0;
	 MemberVO member = (MemberVO)session.getAttribute("clientUser");
	 
	 if(member != null) {
		 cartVO.setId(member.getId());
	  shopService.addCart(cartVO);
	  result = 1;
	 }	
	 return result;
	}
	
	// 카트 목록
	@RequestMapping("cartList")
	public String getCartList(HttpSession session, Model model){

		MemberVO member = (MemberVO)session.getAttribute("clientUser");
		String id = member.getId();

		List<CartListVO> cartList = shopService.cartList(id);
		System.out.println("cartlistVO: "+cartList.toString());
		model.addAttribute("cartList", cartList);
		return "member/cartList";
	}
	
	// 카트 삭제
	@ResponseBody
	@RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
	public int deleteCart(HttpSession session,
	     @RequestParam(value = "chbox[]") List<String> chArr, CartVO cartVO) throws Exception {
	 
	 MemberVO member = (MemberVO)session.getAttribute("clientUser");
	 String id = member.getId();
	 
	 int result = 0;
	 int cartNum = 0;
	 
	 
	 if(member != null) {
		 cartVO.setId(id);
	  
	  for(String i : chArr) {   
	   cartNum = Integer.parseInt(i);
	   cartVO.setCartNum(cartNum);
	   shopService.deleteCart(cartVO);
	  }   
	  result = 1;
	 }  
	 return result;  
	}
	
	// 주문창
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(HttpSession session, Model model) {
		MemberVO member = (MemberVO)session.getAttribute("clientUser");
		String id = member.getId();

		List<CartListVO> cartList = shopService.cartList(id);

		model.addAttribute("cartList", cartList);
		return "member/order";
	}
	
	// 주문
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String order(HttpSession session, OrderVO orderVO, OrderDetailVO orderDetailVO) throws Exception {
	 
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
	 
	 orderVO.setOrderId(orderId);
	 orderVO.setId(id);
	  
	 shopService.orderInfo(orderVO);
	 
	 orderDetailVO.setOrderId(orderId);   
	 shopService.orderInfo_Details(orderDetailVO);
	 System.out.println(orderVO.toString());
	 shopService.deleteAllCart(id);
	 
	 return "member/orderList";  
	}
	
	//주문 목록
	@RequestMapping("orderList")
	public void getOrderList(HttpSession session, OrderVO orderVO, Model model) throws Exception {
	 
	 MemberVO member = (MemberVO)session.getAttribute("clientUser");
	 String id = member.getId();
	 
	 orderVO.setId(id);
	 
	 List<OrderVO> orderList = shopService.orderList(orderVO);
	 System.out.println(orderVO.toString());
	 model.addAttribute("orderList", orderList);
	}
	// 주문 상세 목록
	@RequestMapping("orderView")
	public void getOrderList(HttpSession session,
	      @RequestParam("n") String orderId,
	      OrderVO orderVO, Model model) throws Exception {
	 
	 MemberVO member = (MemberVO)session.getAttribute("clientUser");
	 String id = member.getId();
	 
	 orderVO.setId(id);
	 orderVO.setOrderId(orderId);
	 
	 List<OrderListVO> orderView = shopService.orderView(orderVO);
	 
	 model.addAttribute("orderView", orderView);
	}
}
