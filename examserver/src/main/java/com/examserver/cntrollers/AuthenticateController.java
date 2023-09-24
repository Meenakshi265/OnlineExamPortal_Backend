package com.examserver.cntrollers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examserver.config.jwtUtil;
import com.examserver.helper.UserNotFoundException;
import com.examserver.models.JwtRequest;
import com.examserver.models.JwtResponse;
import com.examserver.models.User;
import com.examserver.services.impl.CustomeUserDeatialsServicveImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomeUserDeatialsServicveImpl customeUserDeatialsServicveImpl;
	
	@Autowired
	private jwtUtil jwtUtil;
		//generate token 
	@RequestMapping( path = "/token"   , method = RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		 System.out.println(jwtRequest);
		 System.out.println(" this is generate token   controller generateToken() method");
		try {
			 System.out.println("...........6666666666666666666");
			this.authenticate(jwtRequest.getUserName(),jwtRequest.getPassword());
			
			 System.out.println("...........55555555555555555555555555");
		}catch (UserNotFoundException e) {
			e.printStackTrace();
			throw new UserNotFoundException("USER NOT FOUND  or bad   credentalis");
		}
		
		
		// authenticates
		UserDetails userDetails=this.customeUserDeatialsServicveImpl.loadUserByUsername(jwtRequest.getUserName());
			String token =this.jwtUtil.generateToken(userDetails);
			 System.out.println(token+"66666666666666666666666666666666666666666666666666666666666666666");
			
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String userName,String password) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
			
			 System.out.println("1111111111111.............................................................................11111");
			
		}catch (DisabledException e) {
			 throw new Exception("USER DISABLED"+e.getMessage());
		}
		catch (BadCredentialsException e) {
			throw new Exception("Invalid  Credentials"+e.getMessage());
		}
		
	}
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		User user= (User)this.customeUserDeatialsServicveImpl.loadUserByUsername(principal.getName());
		return   user;
		
	}
}
