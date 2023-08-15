package com.repository;



import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Voter;
import com.entity.VoterDTO;
import com.entity.Admin;
import com.entity.Candidate;

import jakarta.servlet.http.HttpServletRequest;

@Repository
public class DBOperations {

	@Autowired
	DBPImpl dataTasks;

	@Autowired
	AdminImpl dataBook;

	@Autowired
	CandidateImpl candidateTasks;


	public VoterDTO userAddingImplentation(Voter data)
	{


		return null;
	}


	@SuppressWarnings("unused")
	public boolean newUserAdding(HttpServletRequest data)
	{
		String username = data.getParameter("name");
		String address = data.getParameter("address");
		String gender = data.getParameter("gender");
		String dob = data.getParameter("dob");
		String phonenumber = data.getParameter("phonenumber");
		String citizen = data.getParameter("citizenship");
		String password = data.getParameter("password");
		LocalDate ages = LocalDate.parse(dob);

		// Calculate age
		LocalDate currentDate = LocalDate.now();
		int years = Period.between(ages, currentDate).getYears();
		System.out.println("Voter Age     *****************is"+years);
		if(years>=18)
		{


			Voter voter = new Voter(0, username,null,  gender,dob, address, phonenumber, citizen, password, "Not Approved", "Not Voted");
			Voter save = dataTasks.save(voter);
			System.out.println(save);
			VoterDTO customerDTO = new VoterDTO();
			BeanUtils.copyProperties(save, customerDTO);
			System.out.println(customerDTO+"Copied Data From Database*******************************************");

			if(customerDTO !=null)
			{
				return true;
			}

			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}


	public Boolean loginVoterChecking(String username, String password ) 

	{

		System.out.println(" Voter      Repository Layer*****************************************");

		//		dataTasks
		Voter customer = dataTasks.findByVoternameAndPassword(username, password);
		if(customer !=null)
		{


			System.out.println(customer);
			if(customer.getVotername() .equals(username ) & customer.getPassword().equals(password))
			{
				System.out.println("Valid credentials");
				return true;
			}
			else
			{
				System.out.println("InValid credentials");

				return false;
			}
		}
		else
		{
			return false;
		}

	}


	public boolean candidateAdding(HttpServletRequest data)
	{
		String username = data.getParameter("name");
		String party = data.getParameter("party");
		String dob = data.getParameter("dob");
		String gender = data.getParameter("gender");
		String email = data.getParameter("email");
		String password = data.getParameter("password");
		Candidate candidate = new Candidate(0, party, dob, gender, email, password, "Not Approved");
		System.out.println(candidate);
		Candidate save = candidateTasks.save(candidate);
		System.out.println(save+"Copied Data From Database*******************************************");

		if(save !=null)
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	public Boolean loginCandidateChecking(String username, String password ) 

	{

		System.out.println("Candidate Checking Repository Layer*****************************************");
		Candidate candidateData = candidateTasks.findByEmailAndPassword(username, password);
		//		dataTasks

		if(candidateData !=null)
		{


			System.out.println(candidateData);
			if(candidateData.getEmail().equals(username ) & candidateData.getPassword().equals(password))
			{
				System.out.println("Valid credentials");
				return true;
			}
			else
			{
				System.out.println("InValid credentials");

				return false;
			}
		}
		else
		{
			return false;
		}

	}

	public Boolean loginAdminChecking(String username, String password ) 

	{

		System.out.println(" Login Checking Repository Layer*****************************************");
		Admin adminData = dataBook.findByUseradminAndAdminpassword(username, password);
		//		dataTasks

		if(adminData !=null)
		{


			System.out.println(adminData);
			if(adminData.getUseradmin().equals(username ) & adminData.getAdminpassword().equals(password))
			{
				System.out.println("Valid credentials");
				return true;
			}
			else
			{
				System.out.println("InValid credentials");

				return false;
			}
		}
		else
		{
			return false;
		}

	}
	public Voter displayingData(String username, String number)
	{
		Voter findByVotername = dataTasks.findByVotername(username);
		findByVotername.setVoterid(number);
		findByVotername.setVotingstatus("Approved");
		Voter save = dataTasks.save(findByVotername);
		return save;
	}


	public List<Voter> displayingVoterData( )
	{
		List<Voter> findByVotername = dataTasks.findAll();
		return findByVotername;
	}

	public Voter displayingDataonlyname(String username)
	{
		Voter findByVotername = dataTasks.findByVotername(username);

		return findByVotername;
	}
	
	
	public Voter changeVoteStatus(String username)
	{
		Voter findByVotername = dataTasks.findByVotername(username);
		
		findByVotername.setVoted("voted");
		Voter save = dataTasks.save(findByVotername);
		return save;
	}



}
