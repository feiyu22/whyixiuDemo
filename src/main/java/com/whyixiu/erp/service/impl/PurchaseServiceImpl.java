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
import com.whyixiu.erp.dao.PurchasePlanMapper;
import com.whyixiu.erp.model.Product;
import com.whyixiu.erp.model.PurchasePlan;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.model.vo.PurchaseVo;
import com.whyixiu.erp.service.ProductService;
import com.whyixiu.erp.service.PurchaseService;
import com.whyixiu.erp.until.BeanUtil;

@Service(value="purchasetService")
public class PurchaseServiceImpl implements PurchaseService {

	@Resource
	PurchasePlanMapper purchasePlanMapper;
	
	@Override
	public PurchasePlan getById(Integer id) {
		return purchasePlanMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PurchasePlan> getList(PurchaseVo vo,SysUser user) {
		vo.getPurchasePlan().setCreateBy(user.getName());
		Calendar cal_1=Calendar.getInstance();
		cal_1.set(Calendar.DAY_OF_MONTH,1);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		if(vo.getBeginDate()==null){
			vo.setBeginDate(sdf.format(cal_1.getTime()));
		}
		if(vo.getEndDate()==null){
			vo.setEndDate(sdf.format(new Date()));
		}
		return purchasePlanMapper.selectByUser(vo);
	}

	@Override
	public boolean addPurchase(PurchasePlan purchase) {
		if(purchase.getReceiveNum()==0){
			purchase.setStatus(1);
		}else if(purchase.getNum()==purchase.getReceiveNum()){
			purchase.setStatus(3);
		}else{
			purchase.setStatus(2);
		}
		return purchasePlanMapper.insertSelective(purchase)>0?true:false;
	}

	@Override
	public boolean updatePurchase(PurchasePlan purchase) {
		purchase.setUpdateDate(new Date());
		if(purchase.getNum()==purchase.getReceiveNum()){
			purchase.setStatus(3);
		}
		if(purchase.getNum()>purchase.getReceiveNum()){
			purchase.setStatus(2);
		}
		return purchasePlanMapper.updateByPrimaryKeySelective(purchase)>0?true:false;
	}

	@Override
	public boolean delete(Integer id) {
		PurchasePlan purchase = getById(id);
		purchase.setStatus(0);
		return purchasePlanMapper.updateByPrimaryKeySelective(purchase)>0?true:false;
	}

	@Override
	public List<Map<String, Object>> getListMap(PurchaseVo vo, SysUser user) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String,Object>>();
		List<PurchasePlan> list = getList(vo,user);
		for (PurchasePlan purchasePlan : list) {
			Map<String, Object> map = BeanUtil.beanToMap(purchasePlan);
			switch (String.valueOf(map.get("status"))) {
			case "1":
				map.put("status", "采购");
				break;
			case "2":
				map.put("status", "未完成");
				break;
			case "3":
				map.put("status", "完成");
				break;
			default:
				break;
			}
			listmap.add(map);
		}
		return listmap;
	}


}
