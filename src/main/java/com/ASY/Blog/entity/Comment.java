package com.ASY.Blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="like")
	private int like;
	
	@Column(name="dislike")
	private int dislike;
	
	@Column(name="article_id")
	private int articleId;
	
	@Column(name="user_id")
	private int userId;

	// define constructors
	public Comment() {
		
	}

	// define Setter and Getter method
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	// define tostring
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", like=" + like + ", dislike=" + dislike + ", articleId="
				+ articleId + ", userId=" + userId + "]";
	}

}
