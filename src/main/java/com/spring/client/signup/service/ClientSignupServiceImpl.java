package com.spring.client.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.client.signup.dao.ClientSignupDAO;
import com.spring.common.member.MemberVO;

@Service
public class ClientSignupServiceImpl implements ClientSignupService {
   
   @Autowired
   private ClientSignupDAO clientSignupDAO;
   
   @Override
   public void signup(MemberVO memberVO) {
      clientSignupDAO.signup(memberVO);
   }

   @Override
   public int checkId(MemberVO memberVO) {
       return clientSignupDAO.checkId(memberVO);
   }

   @Override
   public void memberInfo(Model model) {
	model.addAttribute("memberList",clientSignupDAO.memberInfo());
   }

   @Override
   public void memberDelete(int bno) {
	   clientSignupDAO.memberDelete(bno);
   }


}