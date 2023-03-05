package com.gof.examportal.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userRoleId;
	
	
	//user
	@ManyToOne(fetch = FetchType.EAGER)
	private user user;  
	
		
	@ManyToOne(fetch = FetchType.EAGER)
	private Roles role;


	public long getUserRoleId() {
		return userRoleId;
	}


	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}


	public user getUser() {
		return user;
	}


	public void setUser(user user) {
		this.user = user;
	}


	public Roles getRole() {
		return role;
	}


	public void setRole(Roles role) {
		this.role = role;
	}  
	
	

}
