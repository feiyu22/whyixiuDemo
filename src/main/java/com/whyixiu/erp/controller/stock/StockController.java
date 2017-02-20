package com.whyixiu.erp.controller.stock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whyixiu.erp.controller.BaseController;
import com.whyixiu.erp.model.Product;
import com.whyixiu.erp.model.Stock;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.model.vo.InvoicingVo;
import com.whyixiu.erp.model.vo.StockVo;
import com.whyixiu.erp.service.ProductService;
import com.whyixiu.erp.service.StockService;
import com.whyixiu.erp.service.SysUserService;
import com.whyixiu.erp.until.ExcelUtil;
import com.whyixiu.erp.until.ResponseUtil;

@RequestMapping("/stock")
@Controller
public class StockController extends BaseController{

	@Resource
	SysUserService sysUserService;
	
	@Resource
	StockService stockService;
	
	@RequestMapping(value="/redirct")
	public String redirct(HttpServletRequest request,Model model){
		return "redirect:/stock/list";
	}
	
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request,Model model){
		SysUser user = getUserInfoFromSession(request);
		List<Stock> list = stockService.getList(user);
		model.addAttribute("list", list);
		return "stock/list";
	}
	
	@RequestMapping(value="/toAddOrEdit")
	public String toAddOrEdit(@RequestParam(value="id",required=false)Integer id,HttpServletRequest request,Model model){
		if(id!=null){
			Stock stock = stockService.getById(id);
			model.addAttribute("stock", stock);
		}
		return "stock/edit";
	}
	
	@RequestMapping(value="/doAddOrEdit",method=RequestMethod.POST)
	@ResponseBody
	public String doAddOrEdit(Stock stock,HttpServletRequest request){
		SysUser user = getUserInfoFromSession(request);
		if(!stock.getBarcode().equals("")){
			Stock sto = stockService.getByBarCode(stock.getBarcode());
			if(sto.getBarcode()==null){
				stock.setCreateBy(user.getName());
				stock.setCreateDate(new Date());
				stockService.addStock(stock);
			}
		}
		return "{\"code\":300}";
	}
	
	@RequestMapping(value="/exitus")
	public String exitus(HttpServletRequest request,Model model){
		return "stock/exitus";
	}
	
	@RequestMapping(value="/doExitus",method=RequestMethod.POST)
	public String doExitus(Stock stock,HttpServletRequest request,Model model){
		SysUser user = getUserInfoFromSession(request);
		if(!stock.getBarcode().equals("")){
			stock.setStatus(2);
			stock.setCreateBy(user.getName());
			stock.setCreateDate(new Date());
			stockService.addStock(stock);
			stockService.updateStock(stock);
		}
		return "{\"code\":300}";
	}
	
	
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(@RequestParam(value="code",required=false)String code,HttpServletRequest request,Model model){
		List<Stock> list = stockService.getByCode(code);
		model.addAttribute("list", list);
		return "stock/detaillist";
	}
	
	/**
	 * ajax 查询剩余库存
	 * @param str
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ajax",method=RequestMethod.POST)
	@ResponseBody
	public String ajax(@RequestParam(value="barcode",required=false)String barcode,HttpServletRequest request){
		Stock list =  stockService.getByBarCode(barcode);
		if(list.getBarcode()==null){
			list.setCode("301");
		}
		return JSONObject.fromObject(list).toString();
	}
	
	
	//库存操作记录列表
	@RequestMapping(value="/allList")
	public String allList(StockVo vo,HttpServletRequest request,HttpServletResponse response,Model model){
		SysUser user = getUserInfoFromSession(request);
		vo.getStock().setCreateBy(user.getName());
		List<Stock> list = stockService.getAllList(vo,user);
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		return "stock/alllist";
	}
	
	//导出剩余库存的excel
	@RequestMapping(value="/exp")
	public String exp(StockVo vo,HttpServletRequest request,HttpServletResponse response)throws IOException{
		String fileName="剩余库存excel";
		SysUser user = getUserInfoFromSession(request);
		List<Map<String, Object>> list = stockService.getListMap(vo, user);
		String columnNames[]={"序号","产品名称","产品编码","条形码","采购单位","数量","单价","状态","时间"};//列名
	    String keys[] = {"index","name","code","barcode","company","num","price","status","createDate"};//map中的key
	    Workbook excel = ExcelUtil.createWorkBook(list, keys, columnNames);
	    ResponseUtil.uploadExcel(excel, request, response, fileName);
        return null;
	}
	
	//库存操作记录的excel
	@RequestMapping(value="/allExp")
	public String allExp(StockVo vo,HttpServletRequest request,HttpServletResponse response)throws IOException{
		String fileName="库存操作记录excel";
		SysUser user = getUserInfoFromSession(request);
		List<Map<String, Object>> list = stockService.getAllListMap(vo, user);
		String columnNames[]={"序号","产品名称","产品编码","条形码","操作类型","采购单位","数量","单价","时间"};//列名
	    String keys[] = {"index","name","code","barcode","status","company","num","price","createDate"};//map中的key
	    Workbook excel = ExcelUtil.createWorkBook(list, keys, columnNames);
	    ResponseUtil.uploadExcel(excel, request, response, fileName);
        return null;
	}
	
}
