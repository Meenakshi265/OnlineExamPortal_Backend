package com.examserver.models;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	private String authority;
	
	
	public Authority(String authority) {
		super();
		
		this.authority = authority;
		System.out.println("Authority kaa constructor......1");
		
	}


	@Override
	public String getAuthority() {
		
	 System.out.println("Authority kaa getAuthority() method called......1");
		return this.authority;
	}

}
