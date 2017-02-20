package com.whyixiu.erp.controller.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whyixiu.erp.controller.BaseController;
import com.whyixiu.erp.model.Product;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.service.ProductService;
import com.whyixiu.erp.service.SysUserService;

@RequestMapping("/product")
@Controller
public class ProductController extends BaseController{

	@Resource
	SysUserService sysUserService;
	
	@Resource
	ProductService productService;
	
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request,Model model){
		SysUser user = getUserInfoFromSession(request);
		List<Product> list = productService.getList(user);
		model.addAttribute("list", list);
		return "product/plist";
	}
	
	@RequestMapping(value="/toAddOrEdit")
	public String toAddOrEdit(@RequestParam(value="id",required=false)Integer id,HttpServletRequest request,Model model){
		if(id!=null){
			Product product = productService.getById(id);
			model.addAttribute("product", product);
		}
		return "product/pedit";
	}
	
	@RequestMapping(value="/doAddOrEdit",method=RequestMethod.POST)
	public String doAddOrEdit(Product product,HttpServletRequest request){
		SysUser user = getUserInfoFromSession(request);
		if(product.getId()==null){
			product.setCreateBy(user.getName());
			product.setCreateDate(new Date());
			productService.addProduct(product);
		}else{
			productService.updateProduct(product);
		}
		return "redirect:/product/list";
	}
	
	/**
	 * ajax 查询商品
	 * @param str
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ajax",method=RequestMethod.POST)
	@ResponseBody
	public String ajax(@RequestParam String str,HttpServletRequest request){
		if(str!=null&&str!=""){
			List<Product> list = new ArrayList<Product>();
			list = productService.getByAjax(str);
			return JSONArray.fromObject(list).toString();
		}
		return "";
	}
	
	
}
