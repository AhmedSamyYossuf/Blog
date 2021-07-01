package com.ASY.Blog.servece;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ASY.Blog.dao.CommentRepository;
import com.ASY.Blog.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository  commentRepository;

	@Override
	public List<Comment> findAll() {
		
		return commentRepository.findAll();
	}

	@Override
	public Comment findById(int theId) {
		Optional<Comment> result = commentRepository.findById(theId);
		Comment theComment = null ;
		if(result.isPresent()) {
			theComment = result.get() ;
		}
		else {
			throw new RuntimeException("did not find Comment id : " + theId);
		}
		return theComment;
	}

	@Override
	public void save(Comment theComment) {

		commentRepository.save(theComment);
	}

	@Override
	public void deleteById(int theId) {

		commentRepository.deleteById(theId);
	}

}
