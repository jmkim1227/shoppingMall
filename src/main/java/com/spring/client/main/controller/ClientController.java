package com.spring.client.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.client.login.service.ClientLoginService;
import com.spring.common.member.MemberVO;

@Controller
@RequestMapping("member")
public class ClientController {
	@Autowired
    BCryptPasswordEncoder passEncoder;  // 비밀번호 암호화

	@Autowired
    private ClientLoginService clientLoginService;
    
    @PostMapping("/client/user_check.do")
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
         return "redirect:/member/clientLogin.do";
        }
        System.out.println("로그인 성공");
        return "redirect:/index.do";
    }
    
	@RequestMapping("mypage.do")
	public String mypage() {
		return "member/mypage";
	}
	
	@RequestMapping("signup.do")
	public String signup() {
		return "member/signup";
	}
	
}
