package com.whyixiu.erp.model.vo;

import com.whyixiu.erp.model.Invoicing;

public class InvoicingVo {

	private String beginDate;
	
	private String endDate;
	
	private Invoicing invoicing;

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

	public Invoicing getInvoicing() {
		if(invoicing==null){
			invoicing = new Invoicing();
		}
		return invoicing;
	}

	public void setInvoicing(Invoicing invoicing) {
		this.invoicing = invoicing;
	}
	
}
