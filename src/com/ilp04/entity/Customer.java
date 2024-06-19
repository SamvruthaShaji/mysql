package com.ilp04.entity;

public class Customer {
	private int customerCode;
	private String customerFirstame;
	private String CustomerLastname;
	private String address;
	private long phoneNo;
	private long  aadhar;
	public Customer(int customerCode, String customerFirstame, String customerLastname, String address, long phoneNo,
			long aadhar) {
		
		this.customerCode = customerCode;
		this.customerFirstame = customerFirstame;
		CustomerLastname = customerLastname;
		this.address = address;
		this.phoneNo = phoneNo;
		this.aadhar = aadhar;
	}
	 public Customer(String customerFirstame, String customerLastname, String address, long phoneNo, long aadhar) {
	        this.customerFirstame = customerFirstame;
	        CustomerLastname = customerLastname;
	        this.address = address;
	        this.phoneNo = phoneNo;
	        this.aadhar = aadhar;
	    }
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerFirstame() {
		return customerFirstame;
	}
	public void setCustomerFirstame(String customerFirstame) {
		this.customerFirstame = customerFirstame;
	}
	public String getCustomerLastname() {
		return CustomerLastname;
	}
	public void setCustomerLastname(String customerLastname) {
		CustomerLastname = customerLastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
}
