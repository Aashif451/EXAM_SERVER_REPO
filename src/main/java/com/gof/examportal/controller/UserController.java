 package com.gof.examportal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gof.examportal.Models.Roles;
import com.gof.examportal.Models.UserRole;
import com.gof.examportal.Models.user;
import com.gof.examportal.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userservice;
	
	
	//creating user 
	@PostMapping("/")
	public user createUser(@RequestBody user users) throws Exception {
		
		
		Set<UserRole> roles= new HashSet<>();
		Roles role =new Roles();
		role.setRoleid(45L);
		role.setRoleName("NORMAL");
		UserRole userrole=new UserRole();
		userrole.setUser(users);
		userrole.setRole(role);
        roles.add(userrole);
        
		
		return this.userservice.createUsers(users,roles);
		
	}
	
	
@GetMapping("/{username}")	
public user getUser(@PathVariable("username") String username) {
	
	return this.userservice.getUser(username);
	
}

//delete user by id
@DeleteMapping("/{userId}")
public void deleteUser(@PathVariable("userId") Long userId) {
	this.userservice.deleteUser(userId);
	
}


}
