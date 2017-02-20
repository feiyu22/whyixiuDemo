package com.whyixiu.erp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.whyixiu.erp.dao.InvoicingMapper;
import com.whyixiu.erp.model.Invoicing;
import com.whyixiu.erp.model.SysUser;
import com.whyixiu.erp.model.vo.InvoicingVo;
import com.whyixiu.erp.service.InvocingService;
import com.whyixiu.erp.service.SysUserService;
import com.whyixiu.erp.until.BeanUtil;

@Service(value="invocingService")
public class InvocingServiceImpl implements InvocingService {
	
	private static Logger log = Logger.getLogger(InvocingServiceImpl.class);

	@Resource
	InvoicingMapper invoicingMapper;
	
	@Resource
	SysUserService sysUserService;
	
	@Override
	public Invoicing getById(Integer id) {
		return invoicingMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Invoicing> getList(InvoicingVo vo, SysUser user) {
		vo.getInvoicing().setUserId(user.getId());
		Calendar cal_1=Calendar.getInstance();
		cal_1.set(Calendar.DAY_OF_MONTH,1);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		if(vo.getBeginDate()==null){
			vo.setBeginDate(sdf.format(cal_1.getTime()));
		}
		if(vo.getEndDate()==null){
			vo.setEndDate(sdf.format(new Date()));
		}
		return invoicingMapper.selectByUser(vo);
	}
	
	@Override
	public List<Map<String, Object>> getListMap(InvoicingVo vo, SysUser user) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String,Object>>();
		List<Invoicing> list = getList(vo, user);
		for (Invoicing invoicing : list) {
			Map<String, Object> map = BeanUtil.beanToMap(invoicing);
			switch (String.valueOf(map.get("status"))) {
			case "1":
				map.put("status", "进货");
				break;
			case "2":
				map.put("status", "销售");
				break;
			case "3":
				map.put("status", map.get("company")+"月结余");
				break;
			default:
				break;
			}
			switch (String.valueOf(map.get("isShip"))) {
			case "0":
				map.put("isShip", "否");
				break;
			case "1":
				map.put("isShip", "是");
				break;
			default:
				break;
			}
			switch (String.valueOf(map.get("isPay"))) {
			case "0":
				map.put("isPay", "否");
				break;
			case "1":
				map.put("isPay", "是");
				break;
			default:
				break;
			}
			listmap.add(map);
		}
		return listmap;
	}
	

	@Override
	public boolean addInvocing(Invoicing invoicing) {
		if(invoicing.getStatus()==2){
			invoicing.setNum(0-invoicing.getNum());
			invoicing.setTotalPrice(0-invoicing.getTotalPrice());
		}
		if(invoicing.getStatus()==3){
			invoicing.setCompany(invoicing.getCreateDate().getMonth()+"");
			if(invoicing.getCompany().equals("0")){
				invoicing.setCompany("12");
			}
		}
		return invoicingMapper.insertSelective(invoicing)>0?true:false;
	}

	@Override
	public boolean updateiInvocing(Invoicing invoicing) {
		return invoicingMapper.updateByPrimaryKeySelective(invoicing)>0?true:false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Invoicing> getRemain(InvoicingVo vo,Integer userId) {
			Calendar cal_1=Calendar.getInstance();
			cal_1.set(Calendar.DAY_OF_MONTH,1);
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			if(vo.getBeginDate()==null){
				vo.setBeginDate(sdf.format(cal_1.getTime()));
			}
			if(vo.getEndDate()==null){
				vo.setEndDate(sdf.format(new Date()));
			}
			vo.getInvoicing().setUserId(userId);
			List<Invoicing> list = invoicingMapper.selectByType(vo);
//			List<Invoicing> list2 = invoicingMapper.selectByType(vo);
			for (int i = list.size()-1; i >= 0 ; i--) {
				list.get(i).setId(null);
				if(list.get(i).getNum()==0){
					list.remove(i);
				}
			}
			return list;
	}

	@Override
	public void addInList(List<Invoicing> list) {
		for (Invoicing invoicing : list) {
			System.out.println(invoicing);
			Date date = new Date();
			invoicing.setStatus(3);
			invoicing.setCompany((date.getMonth())+"");
			invoicing.setCreateDate(date);
			System.out.println(invoicing);
			addInvocing(invoicing);
		}
	}
	
//	@Scheduled(fixedRate = 5000)
	@Scheduled(cron = "0 0 1 1 * ?")
	@Override
	public void getRemainTask(){
		log.info("-----------开始计算上月结余-------");
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		 //获取前月的第一天
		Calendar   cal_1=Calendar.getInstance();
		cal_1.add(Calendar.MONTH, -1);//获取上月
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号
		//获取前月的最后一天
		Calendar cale = Calendar.getInstance();   
		cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天 
		List<SysUser> list = sysUserService.getByAll();
		for (SysUser sysUser : list) {
			InvoicingVo vo = new InvoicingVo();
			vo.setBeginDate(sdf.format(cal_1.getTime()));
			vo.setEndDate(sdf.format(cale.getTime()));
			vo.getInvoicing().setUserId(sysUser.getId());
			List<Invoicing> inlist = getRemain(vo,sysUser.getId());
			addInList(inlist);
		}
	}
	
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("15");
		System.out.println(list.size());
		for (int i = list.size()-1; i >=0; i--) {
			System.out.println(i+"---"+list.get(i));
			if(list.get(i).equals("4")){
				list.remove(i);
			}
		}
		System.out.println(list.size());
	}
	

}
