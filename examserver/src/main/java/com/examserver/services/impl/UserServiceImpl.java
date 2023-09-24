package com.examserver.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.helper.UserAlreadyFoundException;
import com.examserver.models.User;
import com.examserver.models.User_Role;
import com.examserver.repo.RoleRepository;
import com.examserver.repo.UserRepository;
import com.examserver.services.UserService;


@Service
public class UserServiceImpl  implements UserService{

	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Override
	public User createUser(User user, Set<User_Role> UserRoles) throws Exception {
		 User local =this.userRepo.findByUserName(user.getUserName());
		 if(local!=null) {
			 System.out.println("user is already there !!");
			 throw new UserAlreadyFoundException();
			 
		 }
		 else {
			 for(User_Role ur:UserRoles)	{
				 roleRepo.save(ur.getRole());
			 }
			 
			 user.getUserRoles().addAll(UserRoles);
			local= this.userRepo.save(user);
		 }
		return local;
	}
	
	
	//to get  all users
	@Override
	public List<User> getAllUser() {
	
		List<User> users= new ArrayList<>();
		users=this.userRepo.findAll();
		System.out.println(users);
		return users;
	}
	
	//To get user By user name
	@Override
	public User getUser(String UserName) {
		
		return this.userRepo.findByUserName(UserName);
	}
	
	
	// delete user by userName 
	@Override
	public User deleteUser(String userName) {
		this.userRepo.deleteByUserName(userName);
		
		return this.userRepo.findByUserName(userName);
	}
	
	
	
	
	// delete user by id
	
	@Override
	public  void deleteUser(Long id) {
	this.userRepo.deleteById(id);
	System.out.println( this.userRepo.findById(id));;
	}


	@Override
	public User upadteUser(User user) {
		
		return this.userRepo.save(null);
	}
	
	
	
	
	
	
	

}
