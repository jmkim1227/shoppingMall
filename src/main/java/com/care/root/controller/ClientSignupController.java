package com.care.root.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.root.clientsignupservice.ClientSignupService;
import com.care.root.membervo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class ClientSignupController {
   
   @Autowired
   BCryptPasswordEncoder passEncoder;  // 비밀번호 암호화
   
   @Autowired
   @Inject
   private ClientSignupService clientSignupService;

   private final String codeURI="https://kauth.kakao.com/oauth/authorize?client_id=7fe2ea8fb8719474f5388f06fbf3f3ca&redirect_uri=http://localhost:8088/web/kakaoLogin.do&response_type=code";

   //회원가입 폼
   @RequestMapping(value = "/signup_form", method = { RequestMethod.GET})
   public String signupForm(Model model) {
      return "member/signup";
   }
   
   //회원가입 insert
   @RequestMapping(value = "/signup" , method ={ RequestMethod.POST})
   public String signup(MemberVO memberVO , Model model) {
      
      String inputPass = memberVO.getPwd();
      String pass = passEncoder.encode(inputPass);  // 비밀번호를 암호화
      memberVO.setPwd(pass);  // 암호화된 비밀번호를 userPass에 저장
   
      clientSignupService.signup(memberVO);
      return "redirect:/";
   }
   
      
   //아이디 중복체크
   @RequestMapping(value = "/checkId", method = { RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody int checkId(HttpServletRequest request, Model model) {
        //return clientRegisterService.checkId(regvo);
      
      
      MemberVO regvo1 = new MemberVO();
      
      regvo1.setId(request.getParameter("id"));
      System.out.println(regvo1.getId());
      int result = clientSignupService.checkId(regvo1);
      return result;
    }//
   

}