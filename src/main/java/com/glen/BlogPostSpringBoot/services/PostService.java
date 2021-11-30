package com.glen.BlogPostSpringBoot.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glen.BlogPostSpringBoot.models.Post;
import com.glen.BlogPostSpringBoot.repositories.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepository;
	
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}
	
	public Post getSinglePost(Long id) {
		return postRepository.findById(id).orElse(null);
	
	}

	public Post createNewPost(Post post) {
		Post newPost=postRepository.save(post);
		return newPost;
	}
	
	@Transactional
	public Post editPost(Long id, String title, String body) {
		Post postToUpdate = postRepository.findById(id).orElse(null);
		if(postToUpdate==null)
			return null;
		if(!title.equals(null))
			postToUpdate.setTitle(title);
		if(!body.equals(null))
			postToUpdate.setBody(body);
		postRepository.save(postToUpdate);
		return postToUpdate;
		
	}

	public Post deletePost(Long id) {
		Post postToDelete=postRepository.findById(id).orElse(null);
		if(postToDelete==null)
			return null;
		postRepository.delete(postToDelete);
		return postToDelete;
	}
	
	public PostRepository getPostRepository() {
		return this.postRepository;
	}

	
}
