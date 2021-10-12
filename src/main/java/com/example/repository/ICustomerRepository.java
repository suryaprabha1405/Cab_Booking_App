package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.ICustomerDao;
import com.example.entities.Customer;

@Repository("cDao")
public interface ICustomerRepository extends ICustomerDao, JpaRepository<Customer, Integer> {

}