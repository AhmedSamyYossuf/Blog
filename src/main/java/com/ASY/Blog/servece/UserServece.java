package com.ASY.Blog.servece;

import java.util.List;

import com.ASY.Blog.entity.User;
import com.ASY.Blog.user.CrmUser;

public interface UserServece {

	public List<User> findAll();
	
	public String findCurrentUserName();
	
	public User findById(int theId);
	
	public User findByuserName (String userName);
	
	public void save(CrmUser crmUser);
	
	//public void save(User theUser);
	
	public void deleteById(int theId);
}
