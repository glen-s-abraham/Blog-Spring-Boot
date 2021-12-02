package com.glen.BlogPostSpringBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.glen.BlogPostSpringBoot.models.Post;
import com.glen.BlogPostSpringBoot.models.Comment;
import com.glen.BlogPostSpringBoot.models.User;
import com.glen.BlogPostSpringBoot.repositories.CommentRepository;
import com.glen.BlogPostSpringBoot.repositories.PostRepository;
import com.glen.BlogPostSpringBoot.repositories.UserRepository;

@Configuration
public class BlogFactory {
	@Bean
	CommandLineRunner commandLineRunner(
			PostRepository postRepository,
			CommentRepository postCommentRepository,
			UserRepository userRepository
	) {
		return args->{
			Post post=new Post("test post1","Test post1 body");
			Comment comment = new Comment("Test comment on post 1",post);
			User user= new User("glen","glen@gmail.com");
			postRepository.save(post);
			postCommentRepository.save(comment);
			userRepository.save(user);
		};
		
	}

}
