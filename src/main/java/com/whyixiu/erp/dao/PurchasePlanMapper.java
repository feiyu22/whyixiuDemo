package com.whyixiu.erp.dao;

import java.util.List;

import com.whyixiu.erp.model.PurchasePlan;
import com.whyixiu.erp.model.vo.PurchaseVo;


public interface PurchasePlanMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insertSelective(PurchasePlan record);

    PurchasePlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchasePlan record);
    
    List<PurchasePlan> selectByUser(PurchaseVo vo);

}