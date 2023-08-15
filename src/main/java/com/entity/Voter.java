package com.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voters")
public class Voter {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private String votername;
	private String voterid;
	private String gender;
	
	private String dateofbirth;


	private String address;
	private String mobilenumber;
	private String citizenship;
	private String password;
	private String votingstatus;
	private String voted;
	
	
 


	


	
	public Voter(int id, String votername, String voterid, String gender, String dateofbirth, String address,
			String mobilenumber, String citizenship, String password, String votingstatus, String voted) {
		
		this.id = id;
		this.votername = votername;
		this.voterid = voterid;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.address = address;
		this.mobilenumber = mobilenumber;
		this.citizenship = citizenship;
		this.password = password;
		this.votingstatus = votingstatus;
		this.voted = voted;
	}









	@Override
	public String toString() {
		return "Voter [id=" + id + ", votername=" + votername + ", voterid=" + voterid + ", gender=" + gender
				+ ", dateofbirth=" + dateofbirth + ", address=" + address + ", mobilenumber=" + mobilenumber
				+ ", citizenship=" + citizenship + ", password=" + password + ", votingstatus=" + votingstatus
				+ ", voted=" + voted + "]";
	}









	public int getId() {
		return id;
	}









	public void setId(int id) {
		this.id = id;
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









	public String getPassword() {
		return password;
	}









	public void setPassword(String password) {
		this.password = password;
	}









	public String getVotingstatus() {
		return votingstatus;
	}









	public void setVotingstatus(String votingstatus) {
		this.votingstatus = votingstatus;
	}









	public String getVoted() {
		return voted;
	}









	public void setVoted(String voted) {
		this.voted = voted;
	}









	public Voter() {
	}


}
