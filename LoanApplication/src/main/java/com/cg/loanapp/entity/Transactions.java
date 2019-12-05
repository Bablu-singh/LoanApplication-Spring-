package com.cg.loanapp.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transactions {
	@Id
	@SequenceGenerator(name="trans", sequenceName = "mySeq",allocationSize=1)
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "trans" )
	private Integer trans_id;
	private Integer custId;
	private LocalDateTime timeOfPayment;
	private Double amountPaid;
	private Double balanceAmount;

	public Integer getCustId() {
		return custId;
	}
	public Integer getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(Integer trans_id) {
		this.trans_id = trans_id;
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
