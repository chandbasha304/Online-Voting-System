package com.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Voter;
import com.entity.VoterDTO;
import com.repository.DBOperations;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class VotingOperations {
	
	  @Autowired
	  DBOperations dataAdding;
	public VoterDTO userAdding(Voter data)
	{
		VoterDTO userAddingImplentation = dataAdding.userAddingImplentation(data);
		return userAddingImplentation;
	}
	public Boolean userAdding(HttpServletRequest data)
	{
		boolean newUserAdding = dataAdding.newUserAdding(data);
		
		return newUserAdding;
	}
	
	
	
	
	public Boolean candidataDataAdding(HttpServletRequest data)
	{
		boolean newUserAdding = dataAdding.candidateAdding(data);
		
		return newUserAdding;
	}
	
	
	public List<Voter> allVoterList()
	{
		List<Voter> displayingVoterData = dataAdding.displayingVoterData();
		return displayingVoterData;
	}
	
	public Voter updateVoter(String data)
	{
		
		Random random = new Random();
		String number="";
		
		for (int i = 0; i < 5; i++) {
			String run="";
			int vote = random.nextInt(10);
			String numbers = String.valueOf(vote);
			number+=numbers;
			
			
			
		}
		
		Voter displayingData = dataAdding.displayingData(data,number);
		return displayingData;
	}

}
