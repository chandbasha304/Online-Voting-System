package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Candidate;
import com.entity.Voter;

public interface CandidateImpl extends JpaRepository<Candidate, Integer>{
	Candidate findByEmailAndPassword(String customername,String password);
	
	
	Candidate findByEmail(String customername);
}
