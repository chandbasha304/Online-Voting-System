package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.VotingParty;


public interface FinalCounting extends JpaRepository<VotingParty, Integer> {
	
	
	VotingParty findByParty(String data);
	
	
	List<VotingParty> findAllByOrderByCountpartyDesc();
	
	
	 VotingParty findTopByOrderByCountpartyDesc();

}
