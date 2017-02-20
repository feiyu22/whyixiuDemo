package com.whyixiu.erp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.service.SysUserService;

@RequestMapping("/hello")
@Controller
public class HelloController {
	
	@Resource
	SysUserService sysUserService;

	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam(value = "username", required = false)String username,  
         @RequestParam(value = "password", required = false)String password){
		SysUser user = sysUserService.getByName(username,password);
		return "Hello "+username+",Your password is: "+password +"实际密码"+user.getPassword();  
	}
	
}
