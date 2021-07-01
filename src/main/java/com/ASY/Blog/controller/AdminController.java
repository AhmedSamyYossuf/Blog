package com.ASY.Blog.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ASY.Blog.entity.Article;
import com.ASY.Blog.entity.User;
import com.ASY.Blog.servece.ArticalService;
import com.ASY.Blog.servece.UserServece;



@Controller
@RequestMapping("/admin")
public class AdminController {
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private UserServece userServece ;
	@Autowired
	private ArticalService articalService ;
	
	// add mapping for "/home"
	@GetMapping("/home")
	public String home(Model theModel) {
	
		//Get User from Database
		List<User> theUser = userServece.findAll();
		// add to the spring model
		theModel.addAttribute("users", theUser);
		
		//Get Articles from Database
		List<Article> theArticle = articalService.findAll();
		
		// add to the spring model
		theModel.addAttribute("articles", theArticle);
		
		return "admin/home";
	}
	
	// add mapping for "/articles/list"
	@GetMapping("/articles/list")
	public String listArticle(Model theModel) {
		//Get Articles from Database
		List<Article> theArticle = articalService.findAll();
		
		// add to the spring model
		theModel.addAttribute("articles", theArticle);
		
		return "admin/article/list-articles";
	}
	
	
	// add mapping for "/article/editArticle"
	@GetMapping("/article/editArticle")
	public String editArticle(@RequestParam("articleId") int theId , Model theModel) {
		
		//Get Article from Database
		Article theArticle = articalService.findById(theId);
		//logger.info(">>>>from Edit Article is :" + theArticle.getCategories());
		// add to the spring model
		theModel.addAttribute("article", theArticle);
		
		// add to the spring model flag for page title
		char edit = 'e' ;
		theModel.addAttribute("page_edit", edit);
		
		return "admin/article/article-form";
	}
	
	
	// add mapping for "/articles/add"
	@GetMapping("/articles/add")
	public String addArticle(Model theModel) {
		// get current user 
		String username = userServece.findCurrentUserName();
		logger.info(">>>>>> user name is " + username);
		User theUser = userServece.findByuserName(username);
		logger.info(">>>>>> user Id is " + theUser.getId());
		// Create new article
		Article theArticle = new Article() ;
		theArticle.setUser(theUser);
		theArticle.setCategories(null);
		theArticle.setComments(null);
		
		//theArtical.setUser(theUser);
		theModel.addAttribute("article",theArticle);
		
		// add to the spring model flag for page title
		char edit = 'a' ;
		theModel.addAttribute("page_edit", edit);
				
		return "admin/article/article-form";
	}
	
	
	// add mapping for "/articles/save"
	@PostMapping("/article/save")
	public String saveArticle(@ModelAttribute("article") Article theArticle) {

		articalService.save(theArticle);
		return "redirect:/admin/home";
	}
	
	@GetMapping("/article/delete")
	public String deleteArticle(@RequestParam("articleId") int theId ) {
		
		// delete the employee
		articalService.deleteById(theId);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/home";
	}
	
	
	// add mapping for "/users/list"
	@GetMapping("/users/list")
	public String listUser(Model theModel) {
		
		//Get User from Database
		List<User> theUser = userServece.findAll();
		// add to the spring model
		theModel.addAttribute("users", theUser);
		
		return "admin/users/list-users";
	}
	
}
