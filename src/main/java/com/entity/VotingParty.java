package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "votingcount")
public class VotingParty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String party;
	private int countparty;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getCountparty() {
		return countparty;
	}
	public void setCountparty(int countparty) {
		this.countparty = countparty;
	}
	@Override
	public String toString() {
		return "VotingParty [id=" + id + ", party=" + party + ", countparty=" + countparty + "]";
	}
	public VotingParty(int id, String party, int countparty) {
	
		this.id = id;
		this.party = party;
		this.countparty = countparty;
	}
	public VotingParty() {
		
	}
	
	
	

}
