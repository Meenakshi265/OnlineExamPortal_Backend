package com.examserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examserver.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	

	public User findByUserName( String userName);
	public User deleteByUserName( String userName);
}
