package com.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.VotingParty;

@Repository
public class VotesCountingImpl {
	
	
	@Autowired
	FinalCounting counting;
	
	
	public VotingParty finalVoting(String data)
	{
		
		
		VotingParty findByParty = counting.findByParty(data);
		
		int countparty = findByParty.getCountparty();
		countparty+=1;
		findByParty.setCountparty(countparty);
		VotingParty save = counting.save(findByParty);
		return save;
	}
	
	
	public List<VotingParty> votesResult( )
	{
		
		
		 List<VotingParty> resultVotes = counting.findAllByOrderByCountpartyDesc();
		System.out.println(resultVotes);
		
		return resultVotes;
	}
	
	
	public VotingParty declareResult( )
	{
		VotingParty selectedParty = counting.findTopByOrderByCountpartyDesc();
		
		
		
		return selectedParty;
	}

}
