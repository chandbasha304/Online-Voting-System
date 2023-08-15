package com.entity;

public class CandidateDTO {
	
	
	
	private String partysymbol;
	
	private String gender;
	private String email;
	
	private String status;

	public String getPartysymbol() {
		return partysymbol;
	}

	public void setPartysymbol(String partysymbol) {
		this.partysymbol = partysymbol;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CandidateDTO [partysymbol=" + partysymbol + ", gender=" + gender + ", email=" + email + ", status="
				+ status + "]";
	}

	public CandidateDTO(String partysymbol, String gender, String email, String status) {
		
		this.partysymbol = partysymbol;
		this.gender = gender;
		this.email = email;
		this.status = status;
	}

	public CandidateDTO() {
		
	}
	
	
	

}
