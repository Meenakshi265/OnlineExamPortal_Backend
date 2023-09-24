package com.examserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class User_Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userRoleId;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne()
	private Role role;

	public User_Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User_Role(long userRoleId, User user, Role role) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	


	
	
}
