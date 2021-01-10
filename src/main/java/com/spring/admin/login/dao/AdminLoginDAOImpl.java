package com.spring.admin.login.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.admin.login.vo.AdminVO;

@Repository
public class AdminLoginDAOImpl {
	static String namespace = "com.care.mybatis.adminmapper";
	@Autowired
	SqlSession sqlSession;
	public AdminVO admin_check(String adminid) {
		AdminVO adminVO = null;
		try {
			adminVO = sqlSession.selectOne(namespace+".admin_check", adminid);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return adminVO;
	}
}
