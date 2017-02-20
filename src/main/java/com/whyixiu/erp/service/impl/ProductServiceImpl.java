package com.whyixiu.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whyixiu.erp.dao.ProductMapper;
import com.whyixiu.erp.model.Product;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.service.ProductService;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {

	@Resource
	ProductMapper productMapper;
	
	@Override
	public List<Product> getList(SysUser user) {
		List<Product> list = null;
		if(user!=null){
			list = productMapper.selectByUser(user.getName());
		}
		return list;
	}

	@Override
	public boolean addProduct(Product product) {
		return productMapper.insertSelective(product)>0?true:false;
	}

	@Override
	public boolean updateProduct(Product product) {
		return 	productMapper.updateByPrimaryKeySelective(product)>0?true:false;
	}

	@Override
	public Product getById(Integer id) {
		return productMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Product> getByAjax(String str) {
		List<Product> list = productMapper.selectByName(str);
		return list;
	}

}
