package com.ASY.Blog.servece;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ASY.Blog.dao.CategoryRepository;
import com.ASY.Blog.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(int theId) {
		Optional<Category> result = categoryRepository.findById(theId);
		
		Category tempCategory = null;
		
		if(result.isPresent()) {
			tempCategory = result.get();
		}
		else {
			// we didn't find the category
			throw new RuntimeException("did not find category id : " + theId);
		}
		
		return tempCategory;
	}

	@Override
	public void save(Category theCategory) {
		
		categoryRepository.save(theCategory);
	}

	@Override
	public void deleteById(int theId) {

		categoryRepository.deleteById(theId);
	}

	@Override
	public Category findBycategory(String category) {
		
		return categoryRepository.findBycategory(category);
	}

}
