package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.IDriverDao;
import com.example.entities.Driver;

@Repository("dDao")
public interface IDriverRepository extends IDriverDao, JpaRepository<Driver, Integer> {

}