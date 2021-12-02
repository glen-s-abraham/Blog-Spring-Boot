package com.glen.BlogPostSpringBoot.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.glen.BlogPostSpringBoot.models.Post;
import com.glen.BlogPostSpringBoot.payloads.PostResponse;
import com.glen.BlogPostSpringBoot.services.PostService;

@RestController
@RequestMapping(path="/api/posts")
public class PostController {
	
	@Autowired
	PostService postService;

	@GetMapping
	public PostResponse getPosts(
			@RequestParam(value = "pageNo",defaultValue = "0")Integer pageNo,
			@RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize
	) {
		return postService.getAllPosts(pageNo,pageSize);
	}
	
	@GetMapping("/{id}")
	public Post getSinglePost(@PathVariable("id") Long id) {
		return postService.getSinglePost(id);
	}
	
	@PostMapping
	public Post createNewPost(@RequestBody Post post) {
		return postService.createNewPost(post);
	}
	
	@PutMapping("/{id}")
	public Post editPost(
			@PathVariable("id")Long id,
			@RequestParam("title") String title,
			@RequestParam("body") String body
	) {
		
		return postService.editPost(id,title,body);
	}
	
	@DeleteMapping("/{id}")
	public Post deletePost(@PathVariable("id")Long id) {
		return postService.deletePost(id);
	}
}
