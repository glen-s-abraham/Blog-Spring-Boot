package com.glen.BlogPostSpringBoot.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glen.BlogPostSpringBoot.models.Post;
import com.glen.BlogPostSpringBoot.models.Comment;
import com.glen.BlogPostSpringBoot.repositories.CommentRepository;
import com.glen.BlogPostSpringBoot.repositories.PostRepository;



@Service
public class CommentService {
	
	
	PostService postService;
	CommentRepository postCommentRepository;
	
	@Autowired
	public CommentService(
			PostService postService,
			CommentRepository postCommentRepository) {
		this.postCommentRepository=postCommentRepository;
		this.postService=postService;
	}
	
	public Comment createNewComment(Long postId, Comment comment) {		
		Post postToAddCommentTo = postService.getSinglePost(postId);
		if(postToAddCommentTo!=null) {
			comment.setPost(postToAddCommentTo);
			Comment newComment=postCommentRepository.save(comment);
			return newComment;
		}
		return null;
	}

	public List<Comment> getCommentsOnPost(Long postId) {
		Post postToAddCommentTo = postService.getSinglePost(postId);
		if(postToAddCommentTo!=null) {
			System.out.println(postToAddCommentTo.getComments());
			return postToAddCommentTo.getComments();
		}
		return null;
	}

	public Comment deleteComment(Long commentId) {
		Comment commentToDelete = postCommentRepository.findById(commentId)
				.orElse(null);
		if(commentToDelete!=null) {
			postCommentRepository.delete(commentToDelete);
			return commentToDelete;
		}
		return null;
	}

	public Comment editComment(Long commentId, String body) {
		Comment commentToEdit = postCommentRepository.findById(commentId)
				.orElse(null);
		if(commentToEdit!=null) {
			if(!body.equals(null)) {
				commentToEdit.setBody(body);
				postCommentRepository.save(commentToEdit);
				return commentToEdit;
			}
		}
		return null;
		
		
	}
	

}
