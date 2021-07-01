package com.ASY.Blog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="authority")
	private String authority;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
				name="authorities",
				joinColumns=@JoinColumn(name="roles_id"),
				inverseJoinColumns=@JoinColumn(name="user_id")
			  )
	private List<User> users;
	
	
	public Roles() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Authorities [id=" + id + ", authority=" + authority /*+ ", users=" + users */+ "]";
	}



}
