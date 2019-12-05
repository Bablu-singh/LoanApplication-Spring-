package com.cg.loanapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.loanapp.entity.Transactions;

public interface ITranactionDao extends JpaRepository<Transactions, Integer>{

	@Query("select t from Transactions t where t.custId=:accountNo")
	public List<Transactions> showTransactionsById(int accountNo);
}
