package com.whyixiu.erp.service;

import java.util.List;
import java.util.Map;

import com.whyixiu.erp.model.Product;
import com.whyixiu.erp.model.PurchasePlan;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.model.vo.PurchaseVo;

public interface PurchaseService {
	
	 PurchasePlan getById(Integer id);

	 List<PurchasePlan> getList(PurchaseVo vo, SysUser user);
	 
	 List<Map<String, Object>> getListMap(PurchaseVo vo, SysUser user);
	 
	 boolean addPurchase(PurchasePlan purchase);
	 
	 boolean updatePurchase(PurchasePlan purchase);
	 
	 boolean delete(Integer id);

}
