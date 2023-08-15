package com.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "electionadmin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String useradmin;
	private String adminpassword;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUseradmin() {
		return useradmin;
	}


	public void setUseradmin(String useradmin) {
		this.useradmin = useradmin;
	}


	public String getAdminpassword() {
		return adminpassword;
	}


	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}


	@Override
	public String toString() {
		return "Admin [id=" + id + ", useradmin=" + useradmin + ", adminpassword=" + adminpassword + "]";
	}


	public Admin(int id, String useradmin, String adminpassword) {
		
		this.id = id;
		this.useradmin = useradmin;
		this.adminpassword = adminpassword;
	}
	
	


	public Admin() {
		
	}
	
	

}
