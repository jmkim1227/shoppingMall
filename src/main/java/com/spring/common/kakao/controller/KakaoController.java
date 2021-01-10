//package com.spring.common.kakao.controller;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.care.root.ordervo.OrderVO;
// 
// 
//@Controller
//public class KakaoController {
//    @Autowired private KakaoService kakaoService;
//    
//    
//    @GetMapping("/kakaoPay")
//    public void kakaoPayGet() {
//        
//    }
//    
//    @PostMapping("/kakaoPay")
//    public String kakaoPay() {
//       // log.info("kakaoPay post............................................");
//        
//    	return null;
//    }
//    
//    @GetMapping("/kakaoPaySuccess")
//    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
//       // log.info("kakaoPaySuccess get............................................");
//        //log.info("kakaoPaySuccess pg_token : " + pg_token);
//        return "/default/kakaoPaySuccess";
//    }
//    
//}
// 