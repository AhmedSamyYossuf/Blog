package com.ASY.Blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ASY.Blog.entity.Roles;



public interface RolesRepository extends JpaRepository<Roles, Integer> {
	
	public Roles findByauthority (String authority);

}
