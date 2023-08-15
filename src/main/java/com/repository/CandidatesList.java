package com.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Candidate;

@Repository
public class CandidatesList {
	@Autowired
	CandidateImpl displayCandidates;
	
	public List<Candidate> getAllCandidates()
	{
		
		List<Candidate> findAll = displayCandidates.findAll();
		return findAll;
	}

	
	
	public Boolean approveData(String email)
	{
		
		Candidate candidate = displayCandidates.findByEmail(email);
		
		candidate.setStatus("Approved");
         Candidate save = displayCandidates.save(candidate);	
         System.out.println(save+"Updated *************************************");
		
		return true;
	}
	
	
	public Candidate approveIndividual(String email)
	{
		
		Candidate candidate = displayCandidates.findByEmail(email);
		
		
		
		return candidate;
	}

}
