package com.boot.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String role;
	private String company;
	private String job;
	private String phone;
	private boolean enabled;
	private String imageUrl;
	private String userName;
	private String about;
	private String Linkdin;
	private String email;
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLinkdin() {
		return Linkdin;
	}
	public void setLinkdin(String linkdin) {
		Linkdin = linkdin;
	}
	private String password;
	
	// Unidirectional
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "login_id", referencedColumnName = "id")
//	private Login login;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + ", company=" + company + ", job=" + job
				+ ", phone=" + phone + ", enabled=" + enabled + ", imageUrl=" + imageUrl + ", userName=" + userName
				+ ", about=" + about + ", Linkdin=" + Linkdin + ", email=" + email + ", address=" + address
				+ ", password=" + password + "]";
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
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
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


}
