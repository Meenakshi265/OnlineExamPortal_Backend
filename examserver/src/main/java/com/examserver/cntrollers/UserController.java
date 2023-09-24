package com.examserver.cntrollers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examserver.helper.UserAlreadyFoundException;
import com.examserver.models.Role;
import com.examserver.models.User;
import com.examserver.models.User_Role;
import com.examserver.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	//creating user.....
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		
	   user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		user.setProfile("default.png");
	    Role role1= new Role();
	    role1.setRoleId(10L);
	    role1.setRoleName("NORMAL");
	       
	    Set <User_Role> userRoleSet= new HashSet<>();
	      User_Role userRole=new User_Role();
	      userRole.setRole(role1);
	      userRole.setUser(user);
	      
	      
	      userRoleSet.add(userRole);
	      
	 
		
		return this.userService.createUser(user, userRoleSet);
	}
	
	//To Get all the users
	@GetMapping("/")
	public List<User> getUsers() {
		
		List<User> users=this.userService.getAllUser();
		
		return users;
	}
	
	//to find single user by userName
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") String User_Name) {
		
		return this.userService.getUser(User_Name);
	}
	
//to delete user by user Id 
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		
		 this.userService.deleteUser(id);

	}
	
	

}
