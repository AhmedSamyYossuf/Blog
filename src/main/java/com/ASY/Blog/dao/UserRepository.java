package com.ASY.Blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ASY.Blog.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByuserName (String userName);
}
