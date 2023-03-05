package com.gof.examportal.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class Roles {
	@Id
	private long roleid;
	private String roleName;
	
	
	@OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	private Set<UserRole> userRloes = new HashSet<>(); 
	
	
	public Set<UserRole> getUserRloes() {
		return userRloes;
	}
	public void setUserRloes(Set<UserRole> userRloes) {
		this.userRloes = userRloes;
	}
	public Roles(long roleid, String roleName) {
		super();
		this.roleid = roleid;
		this.roleName = roleName;
	}
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getRoleid() {
		return roleid;
	}
	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}
