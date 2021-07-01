package com.ASY.Blog.servece;

import java.util.List;

import com.ASY.Blog.entity.Roles;

public interface RolesService {

	public List<Roles> findAll();
	
	public Roles findById(int theId);
	
	public Roles findByauthority (String authority);
	
	public void save(Roles theAuthority);
	
	public void deleteById(int theId);
}
