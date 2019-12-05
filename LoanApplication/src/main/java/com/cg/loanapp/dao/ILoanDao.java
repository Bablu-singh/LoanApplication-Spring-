package com.cg.loanapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.loanapp.entity.Loan;

public interface ILoanDao extends JpaRepository<Loan, Integer>{

}
