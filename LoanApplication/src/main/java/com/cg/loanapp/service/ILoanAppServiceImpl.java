package com.cg.loanapp.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.loanapp.dao.ICustomerDao;
import com.cg.loanapp.dao.ILoanDao;
import com.cg.loanapp.dao.ITranactionDao;
import com.cg.loanapp.entity.Customer;
import com.cg.loanapp.entity.Loan;
import com.cg.loanapp.entity.Transactions;
import com.cg.loanapp.exception.CustomerException;
import com.cg.loanapp.exception.LoanException;
import com.cg.loanapp.model.ICustomer;
import com.cg.loanapp.model.IEMI;
import com.cg.loanapp.model.ILoan;
import com.cg.loanapp.model.ITransactions;

@Service
public class ILoanAppServiceImpl implements ILoanAppService {

	@Autowired
	ICustomerDao custrepo;
	@Autowired
	ILoanDao loanrepo;
	@Autowired
	ITranactionDao transrepo;

	static private DecimalFormat df = new DecimalFormat("#,###0.00");

	@Override
	public String addCustomer(ICustomer cust) throws CustomerException {
		// TODO Auto-generated method stub
		System.out.println("Bablu");
		Customer customer = new Customer();
		customer.setName(cust.getName());
		customer.setAddress(cust.getAddress());
		customer.setPhone(cust.getPhone());
		customer.setDob(cust.getDob().toString());
		customer.setEmail(cust.getEmail());
		custrepo.saveAndFlush(customer);
		return ""+customer.getAccountno();
	}

	@Override
	public String applyLoan(ILoan l) throws CustomerException, LoanException {
		// TODO Auto-generated method stub
		Loan loan = new Loan();
		try {
		if(custrepo.existsById(l.getAccountno())) {
		double rate = l.getIntrest() / 100;
		loan.setAccountno(l.getAccountno());
		l.setTotal_amount_to_be_paid(l.getLoan_amount() * (1 + rate * l.getDuration()));
		l.setBalance_amount(l.getTotal_amount_to_be_paid());
		l.setIssue_date(LocalDate.now());
		l.setEmi(l.getTotal_amount_to_be_paid() / (l.getDuration() * 12));

		loan.setDuration(l.getDuration());
		loan.setIntrest(l.getIntrest());
		loan.setLoan_amount(l.getLoan_amount());
		loan.setTotal_amount_to_be_paid(l.getTotal_amount_to_be_paid());
		loan.setEmi(l.getEmi());
		loan.setBalance_amount(l.getBalance_amount());
		loan.setIssue_date(l.getIssue_date());
		loanrepo.saveAndFlush(loan);

		return "Cust Id: " + loan.getAccountno() + " loan of amount " + df.format(loan.getLoan_amount())
				+ " has been successfully granted" + " Time period to pay this loan is: "
				+ LocalDate.now().plusYears(loan.getDuration()) + " Emi you have to pay is: " + df.format(loan.getEmi())
				+ " Total amount: " + df.format(loan.getTotal_amount_to_be_paid());
		}
		else {
			throw new Exception("Customer is not found");
		}
		}
		catch(Exception e) {
			throw new CustomerException(e.getMessage());
		}
		
	}

	@Override
	public String showBalance(int accountNo) throws CustomerException, LoanException {
		// TODO Auto-generated method stub

		try {

			if ((custrepo.existsById(accountNo)) && loanrepo.existsById(accountNo)) {
				Loan lo = loanrepo.findById(accountNo).get();
				double balance = lo.getBalance_amount();
				return "Balance amount to be paid is: " + df.format(balance);
			} else {
				throw new Exception("Customer not exist");
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());
		}
	}

	@Override
	public String payEmi(int accountNo) throws CustomerException, LoanException {
		// TODO Auto-generated method stub

		try {

			if ((custrepo.existsById(accountNo)) && loanrepo.existsById(accountNo)) {
				Loan lo = loanrepo.findById(accountNo).get();
				if (lo.getBalance_amount() > 0) {
					Transactions trans = new Transactions();
					double balance = lo.getBalance_amount() - lo.getEmi();
					trans.setCustId(accountNo);
					trans.setTimeOfPayment(LocalDateTime.now());
					trans.setBalanceAmount(balance);
					trans.setAmountPaid(lo.getEmi());
					transrepo.saveAndFlush(trans);
					lo.setBalance_amount(balance);
					loanrepo.save(lo);
					return "Your new balance amount after paying emi is: " + df.format(lo.getBalance_amount());
				}
				return "You already paid your loan";
			} else {
				throw new Exception("Customer not exist");
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());
		}

	}

	@Override
	public String showEmi(int accountNo) throws CustomerException, LoanException {
		// TODO Auto-generated method stub
		try {
			if ((custrepo.existsById(accountNo)) && loanrepo.existsById(accountNo)) {
				Loan lo = loanrepo.findById(accountNo).get();
				double balance = lo.getBalance_amount();
				if (balance > 0) {
					return "Balance amount to be paid is: " + balance + " Emi to be paid is: " + df.format(lo.getEmi());
				} else {
					return "Loan is already paid";
				}
			} else {
				throw new Exception("Customer not exist");
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());
		}
	}

	@Override
	public String forCloser(int accountNo) throws LoanException {
		// TODO Auto-generated method stub
		try {
			if ((custrepo.existsById(accountNo)) && loanrepo.existsById(accountNo)) {
				Loan lo = loanrepo.findById(accountNo).get();
				double balance = lo.getBalance_amount();
				if (balance > 0) {
					Transactions t = new Transactions();
					t.setCustId(accountNo);
					t.setBalanceAmount(0.0);
					lo.setBalance_amount(0.0);
					t.setAmountPaid(balance - (balance * 3) / 100);
					t.setTimeOfPayment(LocalDateTime.now());
					loanrepo.save(lo);
					transrepo.save(t);
					return "Your loan is Foreclosed.";
				} else {
					return "Your Loan is already paid";
				}
			} else {
				throw new Exception("Customer not exist");
			}
		} catch (Exception e) {
			throw new LoanException(e.getMessage());
		}
	}

	@Override
	public String forCloserBalanceCalculator(int accountNo) throws LoanException {
		// TODO Auto-generated method stub
		try {
			if ((custrepo.existsById(accountNo)) && loanrepo.existsById(accountNo)) {
				Loan lo = loanrepo.findById(accountNo).get();
				double balance = lo.getBalance_amount();
				if (balance > 0) {
					return "You have to pay " + df.format((balance - (balance * 3) / 100));
				} else {
					return "Loan is paid";
				}
			} else {
				throw new Exception("Loan not exist");
			}
		} catch (Exception e) {
			throw new LoanException(e.getMessage());
		}
	}

	@Override
	public List<ITransactions> showTransaction() throws CustomerException {
		// TODO Auto-generated method stub
		try {
			/* if((custrepo.existsById(accountNo)) && loanrepo.existsById(accountNo)) */

			System.out.println("BOB THE BUILdEr");
			// List<Transactions> trans=transrepo.showTransactionsById(accountNo);
			List<Transactions> trans = transrepo.findAll();
			if (!trans.isEmpty()) {
				List<ITransactions> itrans = new ArrayList<ITransactions>();
				for (Transactions transaction : trans) {
					ITransactions it = new ITransactions();
					it.setTrans_id(transaction.getTrans_id());
					it.setAmountPaid(transaction.getAmountPaid());
					it.setBalanceAmount(transaction.getBalanceAmount());
					it.setCustId(transaction.getCustId());
					it.setTimeOfPayment(transaction.getTimeOfPayment());
					itrans.add(it);
				}
				return itrans;
			} else {
				throw new Exception("No transactions made yet");
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());
		}
	}

	@Override
	public String calculateEmi(IEMI emi){
		// TODO Auto-generated method stub
		double rate=emi.getIntrest()/100;
		double total=emi.getAmount()*(1+rate*emi.getDuration());
		int duration=emi.getDuration()*12;
		total=total/duration;
		return "Emi you have to pay is :"+df.format(total);
	}

}
