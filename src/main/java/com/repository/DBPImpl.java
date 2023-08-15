package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.entity.Voter;


public interface DBPImpl extends JpaRepository<Voter, Integer> {
	
	
	Voter findByVoternameAndPassword(String customername,String password);
	Voter findByVotername(String customername);

}
