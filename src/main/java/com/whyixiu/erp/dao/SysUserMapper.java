package com.whyixiu.erp.dao;

import java.util.List;

import com.whyixiu.erp.model.SysUser;


public interface SysUserMapper {

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);
    
    SysUser selectByName(String name);

	List<SysUser> getByAll();

}