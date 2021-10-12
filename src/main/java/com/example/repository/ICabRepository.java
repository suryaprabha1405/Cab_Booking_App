package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dao.ICabDao;
import com.example.entities.Cab;

public interface ICabRepository extends ICabDao, JpaRepository<Cab, Integer> {

}