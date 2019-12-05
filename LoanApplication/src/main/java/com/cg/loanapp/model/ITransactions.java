package com.cg.loanapp.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class ITransactions {
	private Integer trans_id;
	private Integer custId;
	private LocalDateTime timeOfPayment;
	private Double amountPaid;
	private Double balanceAmount;
	
	public Integer getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(Integer trans_id) {
		this.trans_id = trans_id;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public LocalDateTime getTimeOfPayment() {
		return timeOfPayment;
	}
	public void setTimeOfPayment(LocalDateTime timeOfPayment) {
		this.timeOfPayment = timeOfPayment;
	}
	public Double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	
	
}
