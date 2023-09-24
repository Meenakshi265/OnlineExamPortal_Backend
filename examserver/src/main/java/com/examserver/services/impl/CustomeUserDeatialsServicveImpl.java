package com.examserver.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examserver.models.User;
import com.examserver.repo.UserRepository;

@Service
public class CustomeUserDeatialsServicveImpl  implements UserDetailsService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
	User user = this.userRepository.findByUserName(username);
	 System.out.println(".....................................................................222222222222222222222");
	 System.out.println(user);
		
	if(user==null) {
		System.out.println("user is not find ");
		throw new UsernameNotFoundException("no user found expection !! or invalid user name or password");
	} 
	
		
		return user;
	}

}
