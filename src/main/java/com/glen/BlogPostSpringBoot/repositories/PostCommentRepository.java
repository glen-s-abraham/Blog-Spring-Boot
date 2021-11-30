package com.glen.BlogPostSpringBoot.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.glen.BlogPostSpringBoot.models.PostComment;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long>{

}
