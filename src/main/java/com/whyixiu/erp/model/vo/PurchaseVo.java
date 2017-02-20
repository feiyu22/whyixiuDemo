package com.whyixiu.erp.model.vo;

import com.whyixiu.erp.model.PurchasePlan;

public class PurchaseVo {
	
	PurchasePlan purchasePlan;
	
	String beginDate;
	
	String endDate;

	public PurchasePlan getPurchasePlan() {
		if(purchasePlan==null){
			purchasePlan = new PurchasePlan();
		}
		return purchasePlan;
	}

	public void setPurchasePlan(PurchasePlan purchasePlan) {
		this.purchasePlan = purchasePlan;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
