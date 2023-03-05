 package com.gof.examportal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gof.examportal.Models.user;
import com.gof.examportal.repositories.UserRepository;

@Service
public class UserDetailsServiceImple implements UserDetailsService{
 
	
	@Autowired
   private UserRepository userRepository;	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user fuser = this.userRepository.findByUsername(username);
		
		if(fuser==null) {
			System.out.println("User not found ");
			throw new UsernameNotFoundException("No user found");
			
		}
		return fuser;
	}

}
