package com.shubham.repository;

import org.springframework.data.repository.CrudRepository;

import com.shubham.models.Post;

public interface PostRepository extends CrudRepository<Post,Integer> {
	
}
