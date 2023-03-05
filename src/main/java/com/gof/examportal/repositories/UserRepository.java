package com.gof.examportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gof.examportal.Models.user;

public interface UserRepository extends JpaRepository<user, Long> {
	public user findByUsername(String username) ;
	
	

}
