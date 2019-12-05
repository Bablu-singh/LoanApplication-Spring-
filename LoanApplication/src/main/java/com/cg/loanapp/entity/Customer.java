package com.cg.loanapp.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Customer {
	
	@Id
	@Column(name="cust_account_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountno;
	@Column(name="cust_name")
	private String name;
	@Column(name="cust_address")
	private String address;
	@Column(name="cust_phone")
	private String phone;
	@Column(name="cust_email")
	private String email;
	@Column(name="custdob")
	private LocalDate dob;

	
	public int getAccountno() {
		return accountno;
	}
	
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(String db) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob=LocalDate.parse(db, dtf);
		this.dob = dob;
	}
	
}
