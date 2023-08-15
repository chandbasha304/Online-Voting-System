package com.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Voter;
import com.entity.VoterDTO;
import com.repository.DBOperations;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class LoginService {
	@Autowired
	DBOperations loginCredentials;


	public String loginDataChecking(HttpServletRequest data)
	{
		
		System.out.println("Service layer********************************************");
		System.out.println(data.getParameter("username"));
		System.out.println(data.getParameter("password"));
		System.out.println(data.getParameter("usertype"));
		String username = data.getParameter("username");
		String password = data.getParameter("password");
		String usertype = data.getParameter("usertype");
		if(usertype.equalsIgnoreCase("admin"))
		{
			
			System.out.println("Admin Credentials ***************************************************");
			Boolean admincheck = loginCredentials.loginAdminChecking(username,password);
			if (admincheck) {
				System.out.println("Admin Found********************************************************");
				return "adminview";

			}	
			
		}
		else if (usertype.equalsIgnoreCase("voter")) 
		{
			System.out.println("Voter Credentials ***************************************************");
			Boolean loginVoterChecking = loginCredentials.loginVoterChecking(username,password);
			if (loginVoterChecking) {
				System.out.println("Voter Found********************************************************");
				return "voterview";

			}
		}
		else
		{
			System.out.println("Candidate  Credentials********************************************************");
			Boolean loginCandidate = loginCredentials.loginCandidateChecking(username,password);
			if (loginCandidate) {
				System.out.println("Candidate Found********************************************************");
				return "candidateview";

			}
		}
		return "noview";




	}
	
	public Voter displayingVoterData(String username)
	{
		Voter displayingData = loginCredentials.displayingDataonlyname(username);
		VoterDTO voterDTO = new VoterDTO();
		BeanUtils.copyProperties(displayingData, voterDTO);
		return displayingData;
		
	}
	
	
	
	public Voter changingvotingStatus(String username)
	{
		
		Voter changeVoteStatus = loginCredentials.changeVoteStatus(username);
		
		return changeVoteStatus;
		
	}





}
