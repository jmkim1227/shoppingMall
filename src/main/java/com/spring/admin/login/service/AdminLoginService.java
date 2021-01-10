package com.spring.admin.login.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AdminLoginService {
	public int admin_check(HttpServletRequest request, Model model);
}
