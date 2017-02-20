package com.whyixiu.erp.service;

import java.util.List;

import com.whyixiu.erp.model.Product;
import com.whyixiu.erp.model.SysUser;

public interface ProductService {

	 List<Product> getList(SysUser user);
	 
	 boolean addProduct(Product product);
	 
	 boolean updateProduct(Product product);

	 Product getById(Integer id);

	List<Product> getByAjax(String str);
}
