package com.whyixiu.erp.controller.purchase;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.whyixiu.erp.controller.BaseController;
import com.whyixiu.erp.model.Product;
import com.whyixiu.erp.model.PurchasePlan;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.model.vo.PurchaseVo;
import com.whyixiu.erp.service.PurchaseService;
import com.whyixiu.erp.until.ExcelUtil;
import com.whyixiu.erp.until.ResponseUtil;

@Controller
@RequestMapping("/purchase")
public class PurchaseController extends BaseController {

	@Resource
	PurchaseService purchaseService;
	
	@RequestMapping(value="/list")
	public String list(PurchaseVo vo,HttpServletRequest request,Model model){
		SysUser user = getUserInfoFromSession(request);
		List<PurchasePlan> list = purchaseService.getList(vo,user);
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		return "purchase/pulist";
	}
	
	@RequestMapping(value="/toAddOrEdit")
	public String toAddOrEdit(@RequestParam(value="id",required=false)Integer id,HttpServletRequest request,Model model){
		if(id!=null){
			PurchasePlan purchasePlan= purchaseService.getById(id);
			model.addAttribute("purchase", purchasePlan);
		}
		return "purchase/puedit";
	}
	
	@RequestMapping(value="/doAddOrEdit",method=RequestMethod.POST)
	public String doAddOrEdit(PurchasePlan purchase,HttpServletRequest request){
		SysUser user = getUserInfoFromSession(request);
		if(purchase.getId()==null){
			purchase.setCreateBy(user.getName());
			purchase.setCreateDate(new Date());
			purchaseService.addPurchase(purchase);
		}else{
			purchaseService.updatePurchase(purchase);
		}
		return "redirect:/purchase/list";
	}
	
	@RequestMapping(value="/exp")
	public String exp(PurchaseVo vo,HttpServletRequest request,HttpServletResponse response)throws IOException{
		String fileName="采购计划excel";
		SysUser user = getUserInfoFromSession(request);
		List<Map<String, Object>> list = purchaseService.getListMap(vo, user);
		String columnNames[]={"序号","产品名称","产品编码","采购公司","采购数量","到货数量","状态","时间"};//列名
	    String keys[] = {"index","productName","productCode","company","num","receiveNum","status","createDate"};//map中的key
	    Workbook excel = ExcelUtil.createWorkBook(list, keys, columnNames);
	    ResponseUtil.uploadExcel(excel, request, response, fileName);
        return null;
	}
}
