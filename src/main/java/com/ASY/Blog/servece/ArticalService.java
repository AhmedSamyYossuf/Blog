package com.ASY.Blog.servece;

import java.util.List;


import com.ASY.Blog.entity.Article;

public interface ArticalService {

	public List<Article> findAll();
	
	public Article findById(int theId);
	
	public void save(Article theArticle );
	
	public void deleteById(int theId);
}
