package com.cg.loanapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loanapp.exception.CustomerException;
import com.cg.loanapp.exception.LoanException;
import com.cg.loanapp.model.ICustomer;
import com.cg.loanapp.model.IEMI;
import com.cg.loanapp.model.ILoan;
import com.cg.loanapp.model.ITransactions;
import com.cg.loanapp.service.ILoanAppService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoanApplicationController {

	@Autowired
	ILoanAppService service;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody ICustomer cust) throws CustomerException {
		String msg=service.addCustomer(cust);
		return ResponseEntity.ok(msg);
	}

	/*
	 * @PostMapping(value="/addCustomer",consumes =
	 * "application/x-www-form-urlencoded") public ResponseEntity<String>
	 * addCustomer1( ICustomer cust) throws CustomerException { String
	 * msg=service.addCustomer(cust); return ResponseEntity.ok(msg); }
	 */
	@PostMapping("/applyloan")
	public ResponseEntity<String> applyLoan(@RequestBody ILoan loan) throws CustomerException, LoanException{
		String msg=service.applyLoan(loan);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/showBalance")
	public ResponseEntity<String> showBalance(@RequestParam("accountNO") Integer accountNo) throws CustomerException, LoanException {
		String msg=service.showBalance(accountNo);
		return ResponseEntity.ok(msg);
	}
	@GetMapping("/showEmi")
	public ResponseEntity<String> showEmi(@RequestParam("accountNo") Integer accountNo) throws CustomerException, LoanException {
		String msg=service.showEmi(accountNo);
		return ResponseEntity.ok(msg);
	}
	@GetMapping("/payEmi")
	public ResponseEntity<String> payEmi(@RequestParam("accountNo") Integer accountNo) throws CustomerException, LoanException{
		String msg=service.payEmi(accountNo);
		return ResponseEntity.ok(msg);
	}

	/*
	 * @GetMapping("/showTransactions") public ResponseEntity<List>
	 * showTransactions(@RequestParam("accountNo") Integer accountNo) throws
	 * CustomerException{ List<ITransactions>
	 * trans=service.showTransaction(accountNo); return ResponseEntity.ok(trans); }
	 */
	
	  @GetMapping("/showTransactions") public ResponseEntity<List> showTransactions() throws CustomerException{ List<ITransactions>
	  trans=service.showTransaction(); 
	  return ResponseEntity.ok(trans); }
	 
	@GetMapping("/forclosercalc")
	public ResponseEntity<String> forCloserCalc(@RequestParam("accountNo") Integer accountNo) throws LoanException{
		String msg=service.forCloserBalanceCalculator(accountNo);
		return ResponseEntity.ok(msg);
	}
	@GetMapping("/forcloser")
	public ResponseEntity<String> forCloser(@RequestParam("accountNo") Integer accountNo) throws LoanException {
		String msg=service.forCloser(accountNo);
		return ResponseEntity.ok(msg);
	}
	@PostMapping("/calcemi")
	public ResponseEntity<String> emiCalculator(@RequestBody IEMI emi) throws LoanException {
		String msg=service.calculateEmi(emi);
		return ResponseEntity.ok(msg);
	}
}
