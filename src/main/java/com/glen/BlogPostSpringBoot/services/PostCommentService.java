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
	
	
	PostRepository postRepository;
	PostCommentRepository postCommentRepository;
	
	@Autowired
	public PostCommentService(
			PostRepository postRepository,
			PostCommentRepository postCommentRepository) {
		this.postCommentRepository=postCommentRepository;
		this.postRepository=postRepository;
	}
	
	public PostComment createNewComment(Long postId, PostComment comment) {		
		Post postToAddCommentTo = postRepository.findById(postId).orElse(null);
		if(postToAddCommentTo!=null) {
			comment.setPost(postToAddCommentTo);
			PostComment newComment=postCommentRepository.save(comment);
			return newComment;
		}
		return null;
	}

	public List<PostComment> getCommentsOnPost(Long postId) {
		Post postToAddCommentTo = postRepository.findById(postId).orElse(null);
		if(postToAddCommentTo!=null) {
			System.out.println(postToAddCommentTo.getComments());
			return postToAddCommentTo.getComments();
		}
		return null;
	}
	

}
