package com.ASY.Blog.servece;

import java.util.List;

import com.ASY.Blog.entity.Comment;

public interface CommentService {

	public List<Comment> findAll();
	
	public Comment findById(int theId);
	
	public void save(Comment theComment);
	
	public void deleteById(int theId);
}
