package com.boot.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity
public class RTJob {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String name;
	private String salesperson;
	
	@OneToMany(mappedBy = "rtJob")
	private List<SaleOrder> saleOrder;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalesperson() {
		return salesperson;
	}
	public void setSalesperson(String salesperson) {
		this.salesperson = salesperson;
	}

	@Override
	public String toString() {
		return "RTJob [Id=" + Id + ", name=" + name + ", salesperson=" + salesperson + ", saleOrder=" + saleOrder + "]";
	}
	public RTJob(int id, String name, String salesperson) {
		super();
		Id = id;
		this.name = name;
		this.salesperson = salesperson;
	}
	public RTJob() {
		super();
	}
	public List<SaleOrder> getSaleOrder() {
		return saleOrder;
	}
	public void setSaleOrder(List<SaleOrder> saleOrder) {
		this.saleOrder = saleOrder;
	}
	

}
