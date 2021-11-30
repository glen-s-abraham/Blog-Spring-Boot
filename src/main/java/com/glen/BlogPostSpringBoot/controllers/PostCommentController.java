package com.glen.BlogPostSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glen.BlogPostSpringBoot.models.PostComment;
import com.glen.BlogPostSpringBoot.services.PostCommentService;

@RestController
@RequestMapping("/api/")
public class PostCommentController {
	
	@Autowired
	PostCommentService commentService;
	
	@GetMapping("post/{postId}/comment")
	public List<PostComment> getComments(@PathVariable("postId")Long postId) {
		return commentService.getCommentsOnPost(postId);
	}
	
	@PostMapping("post/{postId}/comment")
	public PostComment addNewComment(
			@PathVariable("postId")Long postId,
			@RequestBody PostComment comment
	) {
		
		return commentService.createNewComment(postId,comment);
	}
	
	@DeleteMapping("comment/{commentId}")
	public PostComment deleteComment(
			@PathVariable("commentId")Long commentId
	) {
		return commentService.deleteComment(commentId);
	}
	
	@PutMapping("comment/{commentId}")
	public PostComment editComment(
			@PathVariable("commentId")Long commentId,
			@RequestParam("body") String body
	) {
		return commentService.editComment(commentId,body);
	}
	
}
