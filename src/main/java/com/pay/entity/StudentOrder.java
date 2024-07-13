package com.pay.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderid;
	
	private String name;
	private String email;
	private String phno;
	private String course;
	private Integer amount;
	private String orderStatus;
	private String razorpayOrderId;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}
	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}
	public StudentOrder(Integer orderid, String name, String email, String phno, String course, Integer amount,
			String orderStatus, String razorpayOrderId) {
		super();
		this.orderid = orderid;
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.course = course;
		this.amount = amount;
		this.orderStatus = orderStatus;
		this.razorpayOrderId = razorpayOrderId;
	}
	public StudentOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
