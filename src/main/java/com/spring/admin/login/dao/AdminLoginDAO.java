package com.spring.admin.login.dao;

import java.util.List;

import com.spring.admin.login.vo.AdminVO;

public interface AdminLoginDAO {
	public AdminVO admin_check(String id);
}
