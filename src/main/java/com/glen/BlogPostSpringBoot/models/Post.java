package com.glen.BlogPostSpringBoot.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Post implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="post_sequence")
	@SequenceGenerator(name="post_sequence",
		sequenceName = "post_sequence",
		allocationSize = 1
	)
	Long id;
	String title;
	String body;
	
	public Post() {
		
	}
	
	public Post(Long id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
	
	public Post(String title, String body) {
		this.title = title;
		this.body = body;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + "]";
	}
	
	
	
	
}
