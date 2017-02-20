package com.whyixiu.erp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whyixiu.erp.dao.ProductMapper;
import com.whyixiu.erp.dao.StockMapper;
import com.whyixiu.erp.model.Invoicing;
import com.whyixiu.erp.model.Product;
import com.whyixiu.erp.model.Stock;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.model.vo.StockVo;
import com.whyixiu.erp.service.ProductService;
import com.whyixiu.erp.service.StockService;
import com.whyixiu.erp.until.BeanUtil;

@Service(value="stockService")
public class StockServiceImpl implements StockService {

	@Resource
	StockMapper stockMapper;

	@Override
	public List<Stock> getList(SysUser user) {
		List<Stock> list = null;
		if(user!=null){
			list = stockMapper.selectByUser(user.getName());
		}
		return list;
	}

	@Override
	public Integer addStock(Stock stock) {
		return stockMapper.insertSelective(stock);
	}

	@Override
	public Integer updateStock(Stock stock) {
		Stock sto = stockMapper.selectByBarCode(stock.getBarcode());
		sto.setStatus(0);
		sto.setUpdateDate(new Date());
		return stockMapper.updateByPrimaryKeySelective(sto);
	}

	@Override
	public Stock getById(Integer id) {
		return stockMapper.selectByPrimaryKey(id);
	}

	@Override
	public Stock getByBarCode(String barCode) {
		Stock sto = stockMapper.selectByBarCode(barCode);
		if(sto==null){
			sto = new Stock();
		}
		return sto;
	}

	@Override
	public List<Stock> getByCode(String code) {
		return stockMapper.selectByCode(code);
	}

	@Override
	public List<Map<String, Object>> getListMap(StockVo vo,SysUser user) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String,Object>>();
		vo.getStock().setCreateBy(user.getName());
		vo.getStock().setStatus(1);
		List<Stock> list = stockMapper.selectAll(vo);
		for (Stock stock : list) {
			Map<String, Object> map = BeanUtil.beanToMap(stock);
			switch (String.valueOf(map.get("status"))) {
			case "1":
				map.put("status", "库存");
				break;
			default:
				break;
			}
			listmap.add(map);
		}
		return listmap;
	}
	
	@Override
	public List<Map<String, Object>> getAllListMap(StockVo vo, SysUser user) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String,Object>>();
		List<Stock> list = getAllList(vo, user);
		for (Stock stock : list) {
			Map<String, Object> map = BeanUtil.beanToMap(stock);
			switch (String.valueOf(map.get("status"))) {
			case "0":
				map.put("status", "入库(已出)");
				break;
			case "1":
				map.put("status", "入库");
				break;
			case "2":
				map.put("status", "出库");
				map.put("num", -1);
				break;
			default:
				break;
			}
			listmap.add(map);
		}
		return listmap;
	}
	
	

	@Override
	public List<Stock> getAllList(StockVo vo, SysUser user) {
		vo.getStock().setCreateBy(user.getName());
		Calendar cal_1=Calendar.getInstance();
		cal_1.set(Calendar.DAY_OF_MONTH,1);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		if(vo.getBeginDate()==null){
			vo.setBeginDate(sdf.format(cal_1.getTime()));
		}
		if(vo.getEndDate()==null){
			vo.setEndDate(sdf.format(new Date()));
		}
		return stockMapper.selectAll(vo);
	}

}
