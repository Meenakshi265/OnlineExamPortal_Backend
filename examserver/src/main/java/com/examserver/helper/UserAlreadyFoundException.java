package com.examserver.helper;

public class UserAlreadyFoundException  extends Exception {

	public  UserAlreadyFoundException() {
		super( "user is already found in the data base !!");
	}
}
