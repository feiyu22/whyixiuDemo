package com.whyixiu.erp.service;

import java.util.List;
import java.util.Map;

import com.whyixiu.erp.model.Product;
import com.whyixiu.erp.model.Stock;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.model.vo.StockVo;

public interface StockService {

	 List<Stock> getList(SysUser user);
	 
	 Integer addStock(Stock stock);
	 
	 //将入库数据删除
	 Integer updateStock(Stock stock);

	 Stock getById(Integer id);
	 
	 Stock getByBarCode(String barCode);
	 
	 List<Stock> getByCode(String code);

	 /**
	  * 剩余库存列表 导excel
	  * @param vo
	  * @param user
	  * @return
	  */
	List<Map<String, Object>> getListMap(StockVo vo, SysUser user);
	
	 /**
	  * 所有库存操作列表 导excel
	  * @param vo
	  * @param user
	  * @return
	  */
	List<Map<String, Object>> getAllListMap(StockVo vo, SysUser user);

	/**
	 * 所有操作列表
	 * @param vo
	 * @param user
	 * @return
	 */
	List<Stock> getAllList(StockVo vo, SysUser user);

//	 List<Stock> getByAjax(String str);
}
