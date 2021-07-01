package com.ASY.Blog.servece;

import java.util.List;

import com.ASY.Blog.entity.Category;

public interface CategoryService {

	public List<Category> findAll();
	
	public Category findBycategory (String category);
	
	public Category findById(int theId);
	
	public void save(Category theCategory);
	
	public void deleteById(int theId);
}
