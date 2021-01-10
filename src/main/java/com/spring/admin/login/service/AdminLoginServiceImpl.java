package com.spring.admin.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.admin.login.dao.AdminLoginDAOImpl;
import com.spring.admin.login.vo.AdminVO;


@Service
public class AdminLoginServiceImpl implements AdminLoginService{
	@Autowired
	AdminLoginDAOImpl admindao;
	public int admin_check(HttpServletRequest request, Model model) {
		String adminid = request.getParameter("adminid");
		String pwd = request.getParameter("pwd");
		AdminVO admindto = admindao.admin_check(adminid);
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
}
