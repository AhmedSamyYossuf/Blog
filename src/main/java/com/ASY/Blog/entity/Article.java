package com.ASY.Blog.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="article_body")
	private String articleBody;

	@Column(name="like")
	private int like;
	
	@Column(name="dislike")
	private int dislike;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="article_id")
	private List<Comment> comments;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
				name="article_categories",
				joinColumns=@JoinColumn(name="article_id"),
				inverseJoinColumns=@JoinColumn(name="category_id")
			  )
			  
	private List<Category> categories;
	
	// define constructors
	public  Article() {
		
	}

	// define Setter and Getter method
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArticleBody() {
		return articleBody;
	}

	public void setArticleBody(String articleBody) {
		this.articleBody = articleBody;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public List<Comment> getComments() {
		return comments;
	}

	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	// define tostring
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", articleBody="
				+ articleBody + ", like=" + like + ", dislike=" + dislike + ", user=" + user + ", comments=" + comments
				/*+ ", categories=" + categories*/ + "]";
	}

}
