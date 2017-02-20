package com.whyixiu.erp.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Invoicing {
    private Integer id;

    private Integer productId;
    
    private String productName;
    
    private String productCode;

    private String company;

    private Integer num;

    private Double price;

    private Double totalPrice;

    private String saler;

    //  1/2/3 进货/销售/结余
    private Integer status;

    @DateTimeFormat(pattern="yyyy-MM-dd")  
    private Date createDate;

    private Integer userId;
    
    private Integer isShip;
    
    private Integer isPay;
    
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler == null ? null : saler.trim();
    }

    /**
     * 1/2/3    进货/销售/结余
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date date) {
        this.createDate = date ;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	

	public Integer getIsShip() {
		return isShip;
	}

	public void setIsShip(Integer isShip) {
		this.isShip = isShip;
	}

	public Integer getIsPay() {
		return isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Invoicing [id=" + id + ", productId=" + productId
				+ ", productName=" + productName + ", productCode="
				+ productCode + ", company=" + company + ", num=" + num
				+ ", price=" + price + ", totalPrice=" + totalPrice
				+ ", saler=" + saler + ", status=" + status + ", createDate="
				+ createDate + ", userId=" + userId + "]";
	}
	
}