package com.glen.BlogPostSpringBoot.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.glen.BlogPostSpringBoot.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
