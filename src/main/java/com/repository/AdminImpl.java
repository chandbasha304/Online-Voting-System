package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Admin;
import com.entity.Voter;

public interface AdminImpl extends JpaRepository<Admin, Integer> {
	
	
	Admin findByUseradminAndAdminpassword(String customername,String password);

}
