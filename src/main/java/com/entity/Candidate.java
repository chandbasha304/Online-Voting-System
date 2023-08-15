package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String partysymbol;
	private String dateofbirth;
	private String gender;
	private String email;
	private String password;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPartysymbol() {
		return partysymbol;
	}
	public void setPartysymbol(String partysymbol) {
		this.partysymbol = partysymbol;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", partysymbol=" + partysymbol + ", dateofbirth=" + dateofbirth + ", gender="
				+ gender + ", email=" + email + ", password=" + password + ", status=" + status + "]";
	}
	public Candidate(int id, String partysymbol, String dateofbirth, String gender, String email, String password,
			String status) {
		this.id = id;
		this.partysymbol = partysymbol;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	public Candidate() {
		
	}
	

}
