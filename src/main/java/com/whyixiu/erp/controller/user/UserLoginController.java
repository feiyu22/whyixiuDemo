package com.whyixiu.erp.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whyixiu.erp.constant.WebUtil;
import com.whyixiu.erp.controller.BaseController;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.service.SysUserService;

@RequestMapping("/user")
@Controller
public class UserLoginController extends BaseController{

	@Resource
	SysUserService sysUserService;
	
	@RequestMapping(value="/toLogin")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(SysUser user,Model model,HttpServletRequest request) throws Exception{
		SysUser duser = sysUserService.getByName(user.getName(), user.getPassword());
		if(duser==null){
			model.addAttribute("err", "err");
			model.addAttribute("user", user);
			return "login";
		}
		request.getSession().setAttribute(WebUtil.SESSION_USER, duser);
		model.addAttribute("user", duser);
		return "main1";
	}
	
	@RequestMapping(value ="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "login";
	}
	
}
