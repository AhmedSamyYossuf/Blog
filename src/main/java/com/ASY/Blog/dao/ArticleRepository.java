package com.ASY.Blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ASY.Blog.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {


	
}
