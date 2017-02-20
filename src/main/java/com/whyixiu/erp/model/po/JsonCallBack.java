package com.whyixiu.erp.model.po;

import java.io.Serializable;

import com.alibaba.druid.util.StringUtils;




public class JsonCallBack implements Serializable{

	private static final long serialVersionUID = -3496362494827322210L;
	//成功
	public final static String STATUS_SUCESS_CODE = "0";
	//失败
	public final static String STATUS_ERRORS_CODE = "1";		 
	//成功信息
	public final static String STATUS_SUCESS_INFO = "操作成功";
	//失败信息
	public final static String STATUS_ERRORS_INFO = "操作失败";
	
	//编码
	private String errno;
	//信息
	private String error;
	//跳转地址
	private String url;
	//提示信息
	private String responseText;

	public String getError() {
		return StringUtils.isEmpty(errno)?STATUS_SUCESS_CODE:error;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getErrno() {
		return errno;
	}

	public void setErrno(String errno) {
		this.errno = errno;
	}

	public void setError(String error) {
		this.error = error;
	}
}
