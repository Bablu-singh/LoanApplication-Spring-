package com.cg.loanapp.model;

import org.springframework.stereotype.Component;

@Component
public class ErrorClass {

	Integer errorCode;
	String errorMsg;
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
	
}
