package com.ASY.Blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ASY.Blog.entity.Article;
import com.ASY.Blog.entity.Category;
import com.ASY.Blog.entity.Comment;
import com.ASY.Blog.entity.User;
import com.ASY.Blog.servece.ArticalService;
import com.ASY.Blog.servece.CategoryService;
import com.ASY.Blog.servece.CommentService;
import com.ASY.Blog.servece.UserServece;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServece userServece ;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ArticalService articalService ;
	
	@Autowired
	private CategoryService categoryService;
	
	// add mapping for "/home"
	@GetMapping("/article/home")
	public String listArticles(Model theModel) {
		
		//Get Articles from Database
		List<Article> theArticle = articalService.findAll();
		// add to the spring model
		theModel.addAttribute("articles", theArticle);
		
		// Get Categories from Database
		List<Category> theCategories = categoryService.findAll();
		// add to the spring model
		theModel.addAttribute("categories", theCategories);
		
		return "user/article/home";
	}
	
	// add mapping for "/article/ReadMore"
	@GetMapping("/article/readMore")
	public String readMore(@RequestParam("articleId") int theId,
									Model theModel) {
		
		// get the Article from the service
		Article theArticle = articalService.findById(theId);
		//List<Comment> theComment = theArticle.getComments();
		
		// set Article as a model attribute to pre-populate the form
		theModel.addAttribute("article", theArticle);
		//theModel.addAttribute("comments", theComment);
		
		// Get Categories from Database
		List<Category> theCategories = categoryService.findAll();
		// add to the spring model
		theModel.addAttribute("categories", theCategories);
		
		// add String to the spring model
		String newComment=null;
		theModel.addAttribute("comment", newComment);
		
		// send over to our form
		return "user/article/article-readMore";			
	}
	
	// add mapping for "/article/addcomment"
	@GetMapping("/article/addcomment")
	public String addcomment(@RequestParam("articleId") int theArticleId,
							 @RequestParam("comment") String comment,
									Model theModel) {
		// create new Comment 
		Comment theComment = new Comment();
		theComment.setComment(comment);
		theComment.setArticleId(theArticleId);
		
		User theUser = userServece.findByuserName(userServece.findCurrentUserName());
		theComment.setUserId(theUser.getId());
		
		commentService.save(theComment);
		
		return "redirect:/user/article/home";		
	}
	
	// add mapping for "/article/category"
	@GetMapping("/article/category")
	public String categoryArticles(@RequestParam("category") String category , Model theModel) {
		
		//Get Articles from Database
		Category theCategory = categoryService.findBycategory(category);
		// add to the spring model
		theModel.addAttribute("articles", theCategory.getArticles());
		
		// Get Categories from Database
		List<Category> theCategories = categoryService.findAll();
		// add to the spring model
		theModel.addAttribute("categories", theCategories);
		
		return "user/article/category-articles";
	}
	
	
}
