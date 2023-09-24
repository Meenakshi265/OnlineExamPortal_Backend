package com.examserver.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.examserver.models.User;
import com.examserver.models.User_Role;



public interface UserService {
	 
	public User createUser(User user,Set<User_Role> UserRole) throws Exception;
	
	public List<User> getAllUser();
	
	public User getUser(String UserName) ;
	
	public User upadteUser(User user) ;
	
	public User deleteUser(String userName) ;
	public void deleteUser(Long id) ;
	
	
}
