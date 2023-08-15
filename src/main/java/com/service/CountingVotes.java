package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.VotingParty;
import com.repository.VotesCountingImpl;

@Service
public class CountingVotes {
	
	
	@Autowired
	VotesCountingImpl votesRepo;
	
	
	public VotingParty countVotes(String data)
	{
		
		VotingParty finalVoting = votesRepo.finalVoting(data);
		return finalVoting;
	}
	
	
	
	public VotingParty finalParty( )
	{
		
		VotingParty finalVoting = votesRepo.declareResult();
		return finalVoting;
	}
	
	
	public List<VotingParty> allVotes( )
	{
		
		List<VotingParty> finalVoting = votesRepo.votesResult();
		return finalVoting;
	}

}
