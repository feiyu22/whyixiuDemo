package com.whyixiu.erp.dao;

import java.util.List;

import com.whyixiu.erp.model.Product;


public interface ProductMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);
    
	/**
	 * 模糊查询
	 * @param name
	 * @return
	 */
    List<Product> selectByName(String name);
    
    List<Product> selectByUser(String name);


}