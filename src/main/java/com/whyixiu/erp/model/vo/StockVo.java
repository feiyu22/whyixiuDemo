package com.whyixiu.erp.model.vo;

import com.whyixiu.erp.model.Stock;

public class StockVo {

	private String beginDate;
	
	private String endDate;
	
	private Stock stock;

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

	public Stock getStock() {
		if(stock==null){
			stock = new Stock();
		}
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
}
