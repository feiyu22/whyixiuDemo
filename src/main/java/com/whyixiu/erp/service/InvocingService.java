package com.whyixiu.erp.service;

import java.util.List;
import java.util.Map;

import com.whyixiu.erp.model.Invoicing;
import com.whyixiu.erp.model.Product;
import com.whyixiu.erp.model.PurchasePlan;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.model.vo.InvoicingVo;
import com.whyixiu.erp.model.vo.PurchaseVo;

public interface InvocingService {
	
	 Invoicing getById(Integer id);

	 List<Invoicing> getList(InvoicingVo vo, SysUser user);
	 
	 List<Map<String, Object>> getListMap(InvoicingVo vo, SysUser user);
	 
	 boolean addInvocing(Invoicing invoicing);
	 
	 void addInList(List<Invoicing> list);
	 
	 boolean updateiInvocing(Invoicing invoicing);
	 
	 boolean delete(Integer id);
	 
	 /**
	  * 计算月度   的  个品类结余量
	  * @param endDate  当前时间
	  * @return
	  */
	 List<Invoicing> getRemain(InvoicingVo vo, Integer userId);

	 /**
	  * 定时任务生成上月结余
	  */
	void getRemainTask();

	
	 

}
