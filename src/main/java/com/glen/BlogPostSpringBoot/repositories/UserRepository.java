package com.glen.BlogPostSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glen.BlogPostSpringBoot.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
