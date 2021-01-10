package com.spring.client.login.controller;

import javax.inject.Inject;
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
public class ClientLoginController {
	@Autowired
    BCryptPasswordEncoder passEncoder;  // 비밀번호 암호화

    @Inject
    private ClientLoginService clientLoginService;

    @PostMapping("user_check.do")
    public String user_check(MemberVO memberVO, HttpServletRequest request, RedirectAttributes rttr) 
                                                                                    throws Exception{

    	MemberVO login = clientLoginService.user_check(memberVO);
        HttpSession session = request.getSession();


        if(login != null && passEncoder.matches(memberVO.getPwd(), login.getPwd())) {
         session.setAttribute("clientUser", login);
         session.setAttribute("userId", request.getParameter("id"));
        } else {
         session.setAttribute("clientUser", null);
         rttr.addFlashAttribute("clientmsg", false);
         System.out.println("로그인 실패");
         return "redirect:/member/clientLogin.do";
        }
        System.out.println("로그인 성공");
        return "redirect:/index.do";

    }
    @RequestMapping("clientLogin.do")
    public String clientLogin() {
        return "member/clientLogin";
    }
    @RequestMapping("clientlogout.do")
    public String clientLogout(HttpSession session) throws Exception{
        clientLoginService.clientLogout(session);
        return "redirect:/index.do";
    }
	@RequestMapping("customerservice.do")
	public String customerservice() {
		return "member/customerservice";
	}
	

}
