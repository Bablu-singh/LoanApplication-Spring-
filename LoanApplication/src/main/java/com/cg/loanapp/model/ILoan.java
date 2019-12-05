package com.cg.loanapp.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class ILoan {

	private int accountno;
	private double loan_amount;
	private double total_amount_to_be_paid;
	private double intrest;
	private int duration;
	private double balance_amount;
	private double emi;
	private LocalDate issue_date;
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public double getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
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
	public void setIntrest(double intrest) {
		this.intrest = intrest;
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
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public LocalDate getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(LocalDate issue_date) {
		this.issue_date = issue_date;
	}
	
	
	
}
