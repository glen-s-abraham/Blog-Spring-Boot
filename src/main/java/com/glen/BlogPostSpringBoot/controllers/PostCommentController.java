package com.glen.BlogPostSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glen.BlogPostSpringBoot.models.PostComment;
import com.glen.BlogPostSpringBoot.services.PostCommentService;

@RestController
@RequestMapping("/api/post/{postId}/comment")
public class PostCommentController {
	
	@Autowired
	PostCommentService commentService;
	
	@GetMapping
	public List<PostComment> getComments(@PathVariable("postId")Long postId) {
		return commentService.getCommentsOnPost(postId);
	}
	
	@PostMapping
	public PostComment addNewComment(
			@PathVariable("postId")Long postId,
			@ModelAttribute PostComment comment
	) {
		
		return commentService.createNewComment(postId,comment);
	}
}
