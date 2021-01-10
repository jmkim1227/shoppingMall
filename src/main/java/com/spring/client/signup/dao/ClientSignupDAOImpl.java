package com.spring.client.signup.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.common.member.MemberVO;


@Repository
public class ClientSignupDAOImpl implements ClientSignupDAO {

   @Autowired
   SqlSessionTemplate sqlSession;
   
   static String namespace = "com.care.mybatis.myMapper";

   @Override
   public void signup(MemberVO memberVO) {
      System.out.println(memberVO);
      sqlSession.selectOne(namespace + ".signup",memberVO);
   }
   @Override
   public int checkId(MemberVO memberVO) {
      int result = sqlSession.selectOne(namespace + ".checkId",memberVO);
      return result;
   }
   @Override
   public List<MemberVO> memberInfo() {
	   return sqlSession.selectList(namespace + ".memberInfo"); 
   }
   @Override
   public void memberDelete(int bno) {
	   System.out.println(bno);
	   sqlSession.delete(namespace + ".memberDelete",bno);
   }
   
}
   
   
