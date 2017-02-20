package com.whyixiu.erp.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import com.whyixiu.erp.constant.WebUtil;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.model.po.JsonCallBack;

public class BaseController {
	
	public JsonCallBack  callBack = new JsonCallBack() ;
	//输出Json对象
	public static String getJson(JsonCallBack callBack){
		JSONObject  json = new JSONObject();
		// errno 0成功
		json.put("errno", callBack.getErrno());
		json.put("error", StringUtils.isBlank(callBack.getError())?getErrorInfo(callBack.getErrno()):callBack.getError());
		json.put("url", callBack.getUrl());
		json.put("responseText", callBack.getResponseText());
		return json.toString();
	}

	//输出Json对象
	public static JSON getJsonObject(JsonCallBack callBack){
		JSONObject  json = new JSONObject();
		json.put("errno", callBack.getErrno());
		json.put("error", callBack.getError());
		json.put("url", callBack.getUrl());
		json.put("responseText", callBack.getResponseText());
		return json;
	}

	public static String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("errno", 1);
		obj.put("error", message);
		return obj.toString();
	}
	public static String getErrorInfo(String errno) {
		return StringUtils.equals(errno, "0")?"操作成功":"操作失败";
	}

	public static SysUser  getUserInfoFromSession(HttpServletRequest request){
		SysUser user = null;
		Object obj =request.getSession().getAttribute(WebUtil.SESSION_USER);
		if(obj!=null){
			user = (SysUser)request.getSession().getAttribute(WebUtil.SESSION_USER);
		}
		else{
			return null;
		}
		return user;
	}

}
