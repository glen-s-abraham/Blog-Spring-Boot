package com.glen.BlogPostSpringBoot.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glen.BlogPostSpringBoot.models.Post;
import com.glen.BlogPostSpringBoot.models.PostComment;
import com.glen.BlogPostSpringBoot.repositories.PostCommentRepository;
import com.glen.BlogPostSpringBoot.repositories.PostRepository;



@Service
public class PostCommentService {
	
	
	PostService postService;
	PostCommentRepository postCommentRepository;
	
	@Autowired
	public PostCommentService(
			PostService postService,
			PostCommentRepository postCommentRepository) {
		this.postCommentRepository=postCommentRepository;
		this.postService=postService;
	}
	
	public PostComment createNewComment(Long postId, PostComment comment) {		
		Post postToAddCommentTo = postService.getSinglePost(postId);
		if(postToAddCommentTo!=null) {
			comment.setPost(postToAddCommentTo);
			PostComment newComment=postCommentRepository.save(comment);
			return newComment;
		}
		return null;
	}

	public List<PostComment> getCommentsOnPost(Long postId) {
		Post postToAddCommentTo = postService.getSinglePost(postId);
		if(postToAddCommentTo!=null) {
			System.out.println(postToAddCommentTo.getComments());
			return postToAddCommentTo.getComments();
		}
		return null;
	}

	public PostComment deleteComment(Long commentId) {
		PostComment commentToDelete = postCommentRepository.findById(commentId)
				.orElse(null);
		if(commentToDelete!=null) {
			postCommentRepository.delete(commentToDelete);
			return commentToDelete;
		}
		return null;
	}

	public PostComment editComment(Long commentId, String body) {
		PostComment commentToEdit = postCommentRepository.findById(commentId)
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
