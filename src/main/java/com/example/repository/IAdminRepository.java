package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.IAdminDao;
import com.example.entities.Admin;

@Repository("aDao")
public interface IAdminRepository extends IAdminDao, JpaRepository<Admin, Integer> {

}