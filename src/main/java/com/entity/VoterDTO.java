package com.entity;

public class VoterDTO {
	
	
	private String votername;
	private String voterid;
	private String gender;
	
	private String dateofbirth;


	private String address;
	private String mobilenumber;
	private String citizenship;
	
	private String votingstatus;
	public VoterDTO() {
	}
	public String getVotername() {
		return votername;
	}
	public void setVotername(String votername) {
		this.votername = votername;
	}
	public String getVoterid() {
		return voterid;
	}
	public void setVoterid(String voterid) {
		this.voterid = voterid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	public String getVotingstatus() {
		return votingstatus;
	}
	public void setVotingstatus(String votingstatus) {
		this.votingstatus = votingstatus;
	}
	@Override
	public String toString() {
		return "VoterDTO [votername=" + votername + ", voterid=" + voterid + ", gender=" + gender + ", dateofbirth="
				+ dateofbirth + ", address=" + address + ", mobilenumber=" + mobilenumber + ", citizenship="
				+ citizenship + ", votingstatus=" + votingstatus + "]";
	}
	public VoterDTO(String votername, String voterid, String gender, String dateofbirth, String address,
			String mobilenumber, String citizenship, String votingstatus) {
		this.votername = votername;
		this.voterid = voterid;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.address = address;
		this.mobilenumber = mobilenumber;
		this.citizenship = citizenship;
		this.votingstatus = votingstatus;
	}
	
	



	
}
