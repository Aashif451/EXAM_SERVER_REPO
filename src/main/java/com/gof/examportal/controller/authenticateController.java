
package com.gof.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gof.examportal.Models.JwtResponse;
import com.gof.examportal.Models.jwtRequest;
import com.gof.examportal.config.JwtTokenUtil;
import com.gof.examportal.serviceImpl.UserDetailsServiceImple;

@RestController
public class authenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImple detailsServiceImple ;
	@Autowired
	private JwtTokenUtil jwtUtil;
	
	
	//genrate token
	
	@PostMapping("/generate-token")
	public ResponseEntity<?>generateToken(@RequestBody jwtRequest jwtRequest) throws Exception{
		
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		} catch (UsernameNotFoundException e) {
			
			
			e.printStackTrace();
			
			throw new Exception("user not found");
		}
		
		//authenticate 
		
		UserDetails userDetails = this.detailsServiceImple.loadUserByUsername(jwtRequest.getUsername());
		String token =this.jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
		
		
	}
	
	
	
	

	private void authenticate(String username, String password) throws Exception {

		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			

		} catch (DisabledException e) {
			throw new Exception("User Disabled" + e.getMessage());

		} catch (BadCredentialsException e) {

			throw new Exception("Invalid credential" + e.getMessage());

		}

	}

}
