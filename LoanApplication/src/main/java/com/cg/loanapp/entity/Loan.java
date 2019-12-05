package com.cg.loanapp.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Loan {
	@Id
	@Column(name="ACCOUNT_NO")
	private int accountno;
	@Column(name="loan_amount")
	private double loan_amount;
	@Column(name="total_amount_to_be_paid")
	private double total_amount_to_be_paid;
	@Column(name="intrest")
	private double intrest;
	@Column(name="duration")
	private int duration;
	@Column(name="balance_amount")
	private double balance_amount;
	@SuppressWarnings("unused")
	@Column(name="emi")
	private double emi;
	@Column(name="issue_date")
	private LocalDate issue_date;
		 
	public void setIssue_date(LocalDate issue_date) {
		this.issue_date = issue_date;
	}

	public LocalDate getIssue_date() {
		return issue_date;
	}
	
	public double getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
	}

	public void setEmi(double emi) {
		this.emi=emi;
	}
	public double getEmi() {
		return emi;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	
	public double getTotal_amount_to_be_paid() {
		return total_amount_to_be_paid;
	}
	
	public void setTotal_amount_to_be_paid(double total_amount_to_be_paid) {
		this.total_amount_to_be_paid = total_amount_to_be_paid;
	}

	public double getIntrest() {
		return intrest;
	}
	public void setIntrest(double d) {
		this.intrest = d;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getBalance_amount() {
		return balance_amount;
	}
	public void setBalance_amount(double balance_amount) {
		this.balance_amount = balance_amount;
	}
	
	
	
}
