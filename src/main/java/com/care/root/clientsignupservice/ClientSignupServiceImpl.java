package com.care.root.clientsignupservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.clientsignupdao.ClientSignupDAO;
import com.care.root.membervo.MemberVO;

@Service
public class ClientSignupServiceImpl implements ClientSignupService {
   
   @Autowired
   private ClientSignupDAO clientSignupDAO;
   
   @Override
   public void signup(MemberVO memberVO) {
      // TODO Auto-generated method stub
      clientSignupDAO.signup(memberVO);
   }

   @Override
   public int checkId(MemberVO memberVO) {
      // TODO Auto-generated method stub
       return clientSignupDAO.checkId(memberVO);
   }

}