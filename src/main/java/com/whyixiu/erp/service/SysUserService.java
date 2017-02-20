package com.whyixiu.erp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.whyixiu.erp.model.SysUser;

@Service
public interface SysUserService {

	public SysUser getByName(String name, String password);
	
	public boolean login(String name, String password, HttpServletRequest request);
	
	public List<SysUser> getByAll();
}
