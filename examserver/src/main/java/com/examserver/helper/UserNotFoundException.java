package com.examserver.helper;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super("user not found in the data base with these  username ");
		
	}
	
	public UserNotFoundException(String msg) {
		 super(msg);
	}
	

}
