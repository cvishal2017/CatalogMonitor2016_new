package com.ibm.bluemix.catalogm.dao;

public class BluemixCatalog {
	String seviceName;
	String catagory;
	String vendor;
	String desc;
	String stage;
	String serviceValidFlag;
	
	public String getServiceValidFlag() {
		return serviceValidFlag;
	}
	public void setServiceValidFlag(String serviceValidFlag) {
		this.serviceValidFlag = serviceValidFlag;
	}
	public String getSeviceName() {
		return seviceName;
	}
	public void setSeviceName(String seviceName) {
		this.seviceName = seviceName;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}

}
