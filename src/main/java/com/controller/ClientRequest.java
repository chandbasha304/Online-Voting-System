package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Candidate;
import com.entity.Voter;
import com.entity.VoterDTO;
import com.entity.VotingParty;
import com.repository.DBOperations;
import com.repository.DBPImpl;
import com.service.CandidateService;
import com.service.CountingVotes;
import com.service.LoginService;
import com.service.VotingOperations;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ClientRequest {


	@Autowired
	VotingOperations newuseradding;

	@Autowired
	LoginService loginData;


	@Autowired
	CandidateService showingData;
	
	
	@Autowired
	CountingVotes dataCount;






//	@PostMapping("/newuser")
//	public VoterDTO newdata(@RequestBody Voter data)
//	{
//		System.out.println("Entering");
//		System.out.println(data);
//		VoterDTO adding = newuseradding.userAdding(data);
//
//
//		return adding;
//
//	}




	@PostMapping("/registerfirststep")
	public ModelAndView newdata(HttpServletRequest  data)
	{
		System.out.println("Entering");
		String category = data.getParameter("category");
		System.out.println(category);
		if(category.equalsIgnoreCase("voter"))
		{
			System.out.println("Voter Condition");
			ModelAndView view = new ModelAndView("voterregister");

			return view;
		} 
		else 
		{
			System.out.println("Candiadate Condition");
			ModelAndView view = new ModelAndView("candidateregister");

			return view;
		}

	}


	@PostMapping("/newsignup")   
	public ModelAndView signupaccount(HttpServletRequest data)
	{
		System.out.println("New Voter Data");
		Boolean userAdding = newuseradding.userAdding(data);
		System.out.println(userAdding);
		if(userAdding)
		{
			System.out.println("user Added*************************************************");
			ModelAndView signupView = new ModelAndView("newvotersuccess");
			return signupView;
		}
		else
		{
			System.out.println("user Not Added*************************************************");
			ModelAndView signupView = new ModelAndView("voterformfail");
			return signupView;
		}
	}


	@PostMapping("/newcandidate")
	public ModelAndView newCandidateRegistration(HttpServletRequest data) throws IOException
	{ 

		Boolean candidataDataAdding = newuseradding.candidataDataAdding(data);


		if(candidataDataAdding)
		{
			ModelAndView signupView = new ModelAndView("newcandidatesuccess");
			return signupView;
		}
		else
		{
			ModelAndView modelAndView = new ModelAndView("candidatefail");
			return modelAndView;
		}
	}


	@GetMapping("/first")
	public ModelAndView startProcess()
	{ 
		ModelAndView signupView = new ModelAndView("mainpage");
		return signupView;
	}


	@GetMapping("/loginprocess")
	public ModelAndView loginUser(  )
	{


		ModelAndView view = new ModelAndView("loginaccount");

		return view;

	}

	@PostMapping("/loginuser")
	public ModelAndView loginUserProcess(HttpServletRequest  data)
	{
		String parameter = data.getParameter("username");
		System.out.println(parameter);

		String dataAvailable = loginData.loginDataChecking(data);
		if(dataAvailable.equals("adminview")) 
		{
			ModelAndView view = new ModelAndView("adminloginsuccess");
			view.addObject("admin",parameter);
			return view;
		}
		else if (dataAvailable.equals("voterview")) {
			//			VoterDTO dataFromdb = loginData.displayingVoterData(parameter);
			//			


			ModelAndView modelAndView = new ModelAndView("voterloginsuccess");
			modelAndView.addObject("votername",parameter);
			return modelAndView;

		}
		else if (dataAvailable.equals("candidateview")) {
			ModelAndView modelAndView = new ModelAndView("candidateloginsuccess");
			modelAndView.addObject("candidatename",parameter);
			return modelAndView;

		}
		return new ModelAndView("failedlogin");




	}
	@GetMapping("/registerprocess")
	public ModelAndView registeringVoterOrCandidate()
	{
		System.out.println("Entering");

		ModelAndView view = new ModelAndView("registration");

		return view;

	}


	@GetMapping("/candidateslist")
	public ModelAndView listOfallCandidates()
	{
		System.out.println("Entering");
		List<Candidate> showCandidateData = showingData.showCandidateData();
		System.out.println(showCandidateData);
		ModelAndView view = new ModelAndView("candidatedata");
		view.addObject("candidates",showCandidateData);
		return view;

	}

	@PostMapping("/approve")
	public ModelAndView approvingCandidate(HttpServletRequest data)
	{
		String email = data.getParameter("email");
		System.out.println(email+"    from User Interface*********************************************** ");
		System.out.println("Entering");
		Boolean candidateApproval = showingData.candidateApproval(email);
		if(candidateApproval)
		{
			System.out.println("Aproved Successfully**************");


			ModelAndView view = new ModelAndView("approvesuccess");
			return view;
		}
		else
		{
			System.out.println("Aproved NotSuccessfully**************");
			ModelAndView view = new ModelAndView("approvefail");
			return view;
		}

	}

	@PostMapping("/decline")
	public ModelAndView notApproved(HttpServletRequest data)
	{
		String email = data.getParameter("email");
		System.out.println(email+"    from User Interface*********************************************** ");
		ModelAndView modelAndView = new ModelAndView("approvefail");
		return modelAndView;

	}
	
	
	@PostMapping("/generateVoterId")
	public ModelAndView approveVoter(HttpServletRequest data)
	{
		String email = data.getParameter("voterName");
		Voter updateVoter = newuseradding.updateVoter(email);
		System.out.println(email+"    from User Interface*********************************************** ");
		System.out.println("Entering");
		ModelAndView modelAndView = new ModelAndView("voteridsuccess");
		return modelAndView;

	}

	@GetMapping("/voterlist")
	public ModelAndView listOfallVoters()
	{
		System.out.println("Entering");
		List<Voter> allVoterList = newuseradding.allVoterList();
		System.out.println(allVoterList);
		ModelAndView view = new ModelAndView("voterlistdata");
		view.addObject("voters",allVoterList);
		return view;

	}
	
	
	
	
	@PostMapping("/candidatestatus")
	public ModelAndView displayCandidate(HttpServletRequest  data)
	{
		System.out.println("Entering");
		String parameter = data.getParameter("email");
		System.out.println(parameter+"***************************************************");
		Candidate datafromdb = showingData.candidateDisplayingData(parameter);
		ModelAndView view = new ModelAndView("candidateelection");
		view.addObject("candidate",datafromdb);
		return view;

	}
	
	
	
	
	@PostMapping("/votercandidatedata")
	public ModelAndView displaycandidateToVoterUI(HttpServletRequest  data)
	{
		System.out.println("Entering");
		String parameter = data.getParameter("email");
		System.out.println(parameter+"***************************************************");
		List<Candidate> datafromdb = showingData.showCandidateData();
		ModelAndView view = new ModelAndView("votercandidate");
		view.addObject("votecandidate",datafromdb);
		return view;

	}
	
	
	@PostMapping("/voterstatus")
	public ModelAndView displayVoterdataToVoterUI(HttpServletRequest  data)
	{
		System.out.println("Entering");
		String parameter = data.getParameter("votername");
		System.out.println(parameter+"***************************************************");
		
		Voter voterdata = loginData.displayingVoterData(parameter);
		ModelAndView view = new ModelAndView("votingstatusdata");
		view.addObject("voter",voterdata);
		return view;

	}
	
	
	
	@PostMapping("/votenow")
	public ModelAndView votingFirstProcess(HttpServletRequest data )
	{
		System.out.println(data.getParameter("votername")+"*****************************************");
		String votername = data.getParameter("votername");
		
		ModelAndView view = new ModelAndView("voting");
		view.addObject("votername",votername);
		return view;

	} 
	
	
	
	@PostMapping("/votingcount")
	public ModelAndView votingSecondProcess(HttpServletRequest data )
	{
		String party = data.getParameter("party");
		
		String votername = data.getParameter("votername");
		System.out.println(votername+"***********************");
		System.out.println(party+"***************");
		
		
		
		
		Voter voterdata = loginData.displayingVoterData(votername);
		
		
		if(voterdata.getVoted().equals("voted"))
		{
			ModelAndView view = new ModelAndView("failedvote");
			return view;
			 
		}
		else
		{
			VotingParty countVotes = dataCount.countVotes(party);
			Voter voter = loginData.changingvotingStatus(votername);
			
			ModelAndView view = new ModelAndView("finalvote");
			return view;

		}
		
	} 
	
	
	@GetMapping("/finalresult")
	public ModelAndView finalVoteResult(  )
	{
		List<VotingParty> allVotes = dataCount.allVotes();
		for (VotingParty votingParty : allVotes) {
			System.out.println(votingParty+"********************************");
			
		}
		
		ModelAndView view = new ModelAndView("electionresult");
		view.addObject("votername",allVotes);
		return view;

	}
	
	   
	

	@PostMapping("/electedparty")
	public ModelAndView topCandidate(  )
	{
		VotingParty finalParty = dataCount.finalParty();
		String party = finalParty.getParty();
		System.out.println(party+"**********************************");
		
		ModelAndView view = new ModelAndView("lastprocess");
		view.addObject("votername",party);
		return view;

	}
	


 

}
