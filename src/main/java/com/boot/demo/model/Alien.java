package com.boot.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alien") 
public class Alien {
	@Id
	private int aid;
	private String aname;
	private String atech;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAtech() {
		return atech;
	}
	public void setAtech(String atech) {
		this.atech = atech;
	}
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", atech=" + atech + "]";
	}
	public Alien(int aid, String aname, String atech) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.atech = atech;
	}
	public Alien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
