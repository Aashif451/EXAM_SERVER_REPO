package com.gof.examportal.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.gof.examportal.Models.UserRole;
import com.gof.examportal.Models.user;

public interface UserService {
	
	//create User
	
	public user createUsers(user users, Set<UserRole> userRoles) throws Exception;
//	get user
	public user getUser(String username);
	 
//delete user
	public void deleteUser(Long userId);
	
	//update User
	
}
