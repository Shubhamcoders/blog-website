package com.shubham.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shubham.models.Post;
import com.shubham.repository.PostRepository;

@Service
@Transactional
public class PostService
{
	
	private final PostRepository postRepository;

	public PostService(PostRepository postRepository)
	{
		this.postRepository = postRepository;
	}
	
	public void saveMyPost(Post post)
	{
		postRepository.save(post);
	}
	
	public List<Post> viewAllPost()
	{
		List<Post> post = new ArrayList<Post>();
		for(Post posts : postRepository.findAll())
		{
			post.add(posts);
		}
		
		return post;
	}
	
	public Post editPost(int id)
	{
		return postRepository.findById(id).get();
	}
	
	public void deletePost(int id)
	{
		postRepository.deleteById(id);
	}
}
