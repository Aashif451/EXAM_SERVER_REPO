package com.gof.examportal.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gof.examportal.Models.UserRole;
import com.gof.examportal.Models.user;
import com.gof.examportal.repositories.RoleRepository;
import com.gof.examportal.repositories.UserRepository;
import com.gof.examportal.services.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository; 

	
	//creating user
	@Override
	public user createUsers(user users, Set<UserRole> userRoles) throws Exception  {
	
		
		user Local=this.userRepository.findByUsername(users.getUsername());
		if(Local !=null)
		{
			System.out.println("user is already there!!");
			throw new Exception("user is already there !!");
			
		}
		else
		{
//			create users
			
			for (UserRole ur : userRoles)
			{
				roleRepository.save(ur.getRole());
				
			}
			users.getUserRole().addAll(userRoles);
			Local = this.userRepository.save(users);
			
		}
		
		return Local;
	}

//getting user by name
	@Override
	public user getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void deleteUser(Long userId) {
//		this.userRepository.deleteById(userId);
//		
//	}

}
