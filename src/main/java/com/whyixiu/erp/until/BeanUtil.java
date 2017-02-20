package com.whyixiu.erp.until;

import java.beans.PropertyDescriptor;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtilsBean;

import com.whyixiu.erp.model.SysUser;

public class BeanUtil {

	/**
	 * bean 转 map
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> beanToMap(Object obj) { 
		Map<String, Object> params = new HashMap<String, Object>(0); 
		try { 
			PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
			PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
			for (int i = 0; i < descriptors.length; i++) { 
				String name = descriptors[i].getName(); 
				if (!"class".equals(name)) { 
					params.put(name, propertyUtilsBean.getNestedProperty(obj, name)); 
				} 
			} 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return params; 
	}
	
	public static void main(String[] args) {
		SysUser user = new SysUser();
		user.setName("dafeiyu");
		user.setCreateDate(new Date());
		Map<String, Object> map = beanToMap(user);
		Iterator<String> keys = map.keySet().iterator(); 
	    while(keys.hasNext()) { 
		   String key = (String) keys.next(); 
		   Object value = map.get(key); 
		   System.out.println("键"+key+"="+"值"+value); 
	    }
	}
}
