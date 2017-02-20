package com.whyixiu.erp.controller.invoicing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whyixiu.erp.controller.BaseController;
import com.whyixiu.erp.model.Invoicing;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.model.vo.InvoicingVo;
import com.whyixiu.erp.model.vo.PurchaseVo;
import com.whyixiu.erp.service.InvocingService;
import com.whyixiu.erp.until.ExcelUtil;
import com.whyixiu.erp.until.ResponseUtil;

@RequestMapping("/invocing")
@Controller
public class InvoicingController extends BaseController{
	
	@Resource
	InvocingService invocingService;
	
	@RequestMapping(value="/list")
	public String list(InvoicingVo vo,HttpServletRequest request,Model model){
		SysUser user = getUserInfoFromSession(request);
		List<Invoicing> list = invocingService.getList(vo,user);
		List<Invoicing> reList = invocingService.getRemain(vo, user.getId());
		model.addAttribute("list", list);
		model.addAttribute("reList", reList);
		model.addAttribute("vo", vo);
		return "invoicing/inlist";
	}
	
	@RequestMapping(value="/toAddOrEdit")
	public String toAddOrEdit(@RequestParam(value="id",required=false)Integer id,HttpServletRequest request,Model model){
		if(id!=null){
			Invoicing invoicing = invocingService.getById(id);
			model.addAttribute("invoicing", invoicing);
		}
		return "invoicing/inedit";
	}
	
	@RequestMapping(value="/doAddOrEdit",method=RequestMethod.POST)
	public String doAddOrEdit(Invoicing invoicing,HttpServletRequest request){
		SysUser user = getUserInfoFromSession(request);
		if(invoicing.getId()==null){
			invoicing.setUserId(user.getId());
			invocingService.addInvocing(invoicing);
		}else{
			invocingService.updateiInvocing(invoicing);
		}
		return "redirect:/invocing/list";
	}
	
	@RequestMapping(value="/exp")
	public String exp(InvoicingVo vo,HttpServletRequest request,HttpServletResponse response)throws IOException{
		String fileName="进销存excel";
		SysUser user = getUserInfoFromSession(request);
		List<Map<String, Object>> list = invocingService.getListMap(vo, user);
		String columnNames[]={"序号","产品名称","产品编码","采购/销售公司","数量","单价","状态","销售人","时间","是否发货","是否打款"};//列名
	    String keys[] = {"index","productName","productCode","company","num","price","status","saler","createDate","isShip","isPay"};//map中的key
	    Workbook excel = ExcelUtil.createWorkBook(list, keys, columnNames);
	    ResponseUtil.uploadExcel(excel, request, response, fileName);
        return null;
	}
}
