package com.whyixiu.erp.dao;

import java.util.List;

import com.whyixiu.erp.model.Invoicing;
import com.whyixiu.erp.model.vo.InvoicingVo;


public interface InvoicingMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Invoicing record);

    Invoicing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Invoicing record);
    
    List<Invoicing> selectByUser(InvoicingVo vo);
    
    /**
     * 根据时间  用户id  获取当月总 进销分类记录计算后产生的结余
     * @param vo
     * @return
     */
    List<Invoicing> selectByType(InvoicingVo vo);

}