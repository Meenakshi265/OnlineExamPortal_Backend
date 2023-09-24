package com.examserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examserver.models.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{

}
