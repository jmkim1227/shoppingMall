package com.care.root.clientsignupdao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.root.membervo.MemberVO;

@Repository
public class ClientSignupDAOImpl implements ClientSignupDAO {

   @Autowired
   SqlSessionTemplate sqlSessionTemplate;
   
   static String namespace = "com.care.mybatis.myMapper";

   @Override
   public void signup(MemberVO memberVO) {
      System.out.println(memberVO);
      sqlSessionTemplate.insert(namespace + ".signup",memberVO);
      
   }

   @Override
   public int checkId(MemberVO memberVO) {
      int result = sqlSessionTemplate.selectOne(namespace + ".checkId",memberVO);
      return result;
   }
   
}
   
   
