package com.whyixiu.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.whyixiu.erp.dao.SysUserMapper;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.service.SysUserService;
import com.whyixiu.erp.until.EncUtil;

@Service(value="sysUserService")
public class SysUserServiceImpl implements SysUserService{
	
	@Resource
	SysUserMapper sysUserMapper;

	@Override
	public SysUser getByName(String name,String password) {
		SysUser user = sysUserMapper.selectByName(name);
		if(user!=null&&user.getPassword().equalsIgnoreCase(EncUtil.compMD5Encry(password, 6))){
			return user;
		}
		return null;
	}

	@Override
	public boolean login(String name, String password, HttpServletRequest request) {
		
		return false;
	}

	@Override
	public List<SysUser> getByAll() {
		return sysUserMapper.getByAll();
	}

}
