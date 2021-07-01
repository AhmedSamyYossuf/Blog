package com.ASY.Blog.servece;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ASY.Blog.dao.ArticleRepository;
import com.ASY.Blog.entity.Article;

@Service
public class ArticalServiceImpl implements ArticalService {
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public List<Article> findAll() {
		
		return articleRepository.findAll();
	}

	@Override
	public Article findById(int theId) {
		Optional<Article> result = articleRepository.findById(theId);
		
		Article tempArticle = null;
		
		if(result.isPresent()) {
			tempArticle = result.get();
		}
		else {
			// we didn't find the Article
			throw new RuntimeException("did not find Article id : " + theId);
		}
		
		return tempArticle;
	}

	@Override
	public void deleteById(int theId) {
		
		articleRepository.deleteById(theId);
	}

	@Override
	public void save(Article theArticle) {
		/*
		logger.info(">>>>from save methode is :");
		logger.info(">>>>from save Article Title 		is :" + theArticle.getTitle());
		logger.info(">>>>from save Article Description 	is :" + theArticle.getDescription());
		logger.info(">>>>from save Article ArticleBody 	is :" + theArticle.getArticleBody());
		logger.info(">>>>from save Article Id 			is :" + theArticle.getId());
		logger.info(">>>>from save Article getDislike 	is :" + theArticle.getDislike());
		logger.info(">>>>from save Article getLike 		is :" + theArticle.getLike());
		logger.info(">>>>from save Article Comments 	is :" + theArticle.getComments());
		logger.info(">>>>from save Article User 		is :" + theArticle.getUser());
		logger.info(">>>>from save Article Categories 	is :" + theArticle.getCategories());
		*/
		articleRepository.save(theArticle);
	}

}
