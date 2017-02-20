package com.whyixiu.erp.dao;

import java.util.List;

import com.whyixiu.erp.model.Invoicing;
import com.whyixiu.erp.model.Stock;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.model.vo.StockVo;


public interface StockMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stock record);
    
    //剩余库存列表
    List<Stock> selectByUser(String name);
    
    //剩余详细
    List<Stock> selectByCode(String code);

    //通过条码查询剩余库存
	Stock selectByBarCode(String barcode);

	//出入库列表  通过status 字段判断
	List<Stock> selectAll(StockVo vo);
}