package com.glen.BlogPostSpringBoot.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_sequence")
	@SequenceGenerator(
			name="comment_sequence",
			sequenceName = "comment_sequence",
			allocationSize = 1
	)
	Long id;
	String body;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	@JsonIgnore
	Post post;
	
	public Comment() {
		
	}
	
	
	public Comment(Long id, String body, Post post) {
		this.body = body;
		this.post = post;
	}
	
	public Comment(String body, Post post) {
		this.body = body;
		this.post = post;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", body=" + body + "]";
	}
	
}
