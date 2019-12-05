package com.cg.loanapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.loanapp.entity.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Integer> {

}
