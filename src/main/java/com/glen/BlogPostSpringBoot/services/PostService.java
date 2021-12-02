package com.glen.BlogPostSpringBoot.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.glen.BlogPostSpringBoot.payloads.PostResponse;
import com.glen.BlogPostSpringBoot.models.Post;
import com.glen.BlogPostSpringBoot.repositories.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepository;
	
	public PostResponse getAllPosts(
			Integer pageNo,Integer pageSize,String sortBy,String sortDir
	){
		Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize,sort);
		Page<Post> posts = postRepository.findAll(pageable);
		return new PostResponse(
				posts.getContent(),
				posts.getNumber(),
				posts.getSize(),
				posts.getTotalElements(),
				posts.getTotalPages(),
				posts.isLast()
		);
		
		
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
