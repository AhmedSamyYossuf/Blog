package com.ASY.Blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ASY.Blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
