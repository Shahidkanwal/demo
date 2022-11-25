package com.boot.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SaleOrder {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String name;
	private int totalAmt;
	
	public SaleOrder(int id, String name, int totalAmt) {
		super();
		Id = id;
		this.name = name;
		this.totalAmt = totalAmt;
	}
	 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="rt_job_id", nullable=false)
	private RTJob rtJob;
	
	public RTJob getRtJob() {
		return rtJob;
	}
	public void setRtJob(RTJob rtJob) {
		this.rtJob = rtJob;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public SaleOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SaleOrder [Id=" + Id + ", name=" + name + ", totalAmt=" + totalAmt + "]";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}
}
