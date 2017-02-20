package com.whyixiu.erp.interceptor;

import com.whyixiu.erp.constant.WebUtil;
import com.whyixiu.erp.model.SysUser;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static Logger log = Logger.getLogger(LoginInterceptor.class);
	
	 private static final String[] IGNORE_URI = {"/user/login", "/user/toLogin"};
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		log.info("请求url："+request.getRequestURL().toString());
		SysUser user = (SysUser)request.getSession().getAttribute(WebUtil.SESSION_USER);
		String url = request.getRequestURL().toString();
		for (String s : IGNORE_URI) {
            if (url.contains(s)) {
            	return true;
            }
        }
		if(user!=null){
			return true;
		}
		response.getWriter().print("<script type=\"text/javascript\">window.open('"+request.getContextPath()+"/user/toLogin', '_top');</script>");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
