package com.ASY.Blog.servece;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ASY.Blog.dao.RolesRepository;
import com.ASY.Blog.dao.UserRepository;
import com.ASY.Blog.entity.Roles;
import com.ASY.Blog.entity.User;
import com.ASY.Blog.user.CrmUser;

@Service
public class UserServeceImpl implements UserServece {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User findById(int theId) {
		Optional<User> result = userRepository.findById(theId);
		User theUser = null ;
		if(result.isPresent()) {
			theUser = result.get() ;
		}
		else {
			throw new RuntimeException("did not find User id : " + theId);
		}
		return theUser;
	}

	@Override
	public void save(CrmUser crmUser) {
		//logger.info(">>>>from save username is :" + crmUser.getUserName());
		User theUser = new User();
		// assign user details to the user object
		theUser.setUserName(crmUser.getUserName());
		/*
		logger.info(">>>>from save username2 is :" + crmUser.getUserName());
		logger.info(">>>>from theUser username2 is :" + theUser.getUserName());
		*/
		theUser.setPassword(crmUser.getPassword());
		/*
		logger.info(">>>>from save pass is :" + crmUser.getPassword());
		logger.info(">>>>from theUser pass is :" + theUser.getPassword());
		*/
		theUser.setEmail(crmUser.getEmail());
		/*
		logger.info(">>>>from save email is :" + crmUser.getEmail());
		logger.info(">>>>from theUser email is :" + theUser.getEmail());
		/*
		
		// give user default role of "user"
		theUser.setAuthorities(Arrays.asList(rolesRepository.findByauthority("ROLE_user")));
		/*
		logger.info(">>>>from theUser roles is :" );
		logger.info(">>>>from theUser roles is :" + theUser.getAuthorities());
		*/
		userRepository.save(theUser);
	}

	@Override
	public void deleteById(int theId) {
		
		userRepository.deleteById(theId);
	}

	@Override
	public User findByuserName(String userName) {
		
		Optional<User> result  = Optional.ofNullable(userRepository.findByuserName(userName));
		User theUser = null ;
		if(result.isPresent()) {
			theUser = result.get() ;
		}
		//throw new RuntimeException("did not find User Name : " + userName);
			
		return theUser;
	}

	@Override
	public String findCurrentUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null ;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		return username;
	}

}
