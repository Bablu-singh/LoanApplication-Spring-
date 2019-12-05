package com.cg.loanapp.service;

import java.util.List;
import java.util.Map;

import com.cg.loanapp.exception.CustomerException;
import com.cg.loanapp.exception.LoanException;
import com.cg.loanapp.model.ICustomer;
import com.cg.loanapp.model.IEMI;
import com.cg.loanapp.model.ILoan;
import com.cg.loanapp.model.ITransactions;

public interface ILoanAppService {
	String addCustomer(ICustomer c) throws CustomerException;
	String applyLoan(ILoan l ) throws CustomerException,LoanException;
	String showBalance(int accountNo) throws CustomerException,LoanException;
	String payEmi(int accountNo) throws CustomerException,LoanException;
	String showEmi(int accountNo) throws CustomerException,LoanException;
	String forCloser(int accountNo) throws LoanException;
	String forCloserBalanceCalculator(int accountNo) throws LoanException;
	List<ITransactions> showTransaction() throws CustomerException;
	String calculateEmi(IEMI emi);
}
