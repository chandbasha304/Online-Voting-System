package com.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Candidate;
import com.entity.CandidateDTO;
import com.repository.CandidatesList;

@Service
public class CandidateService {
	
	@Autowired
	CandidatesList allDataFromDB;
	
	
	public List<Candidate> showCandidateData()
	{
		List<Candidate> allCandidates = allDataFromDB.getAllCandidates();
			return allCandidates;
	}
	
	
	public Boolean candidateApproval(String data)
	{
		
		
		Boolean approveData = allDataFromDB.approveData(data);
		
		
		return approveData;
	}
	
	public Candidate candidateDisplayingData(String data)
	{
		
		
		Candidate approveData = allDataFromDB.approveIndividual(data);
		
		
		return approveData;
	}

}
