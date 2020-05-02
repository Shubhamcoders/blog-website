package com.shubham.repository;

import org.springframework.data.repository.CrudRepository;

import com.shubham.models.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	
	public User findByUsernameAndPassword(String username,String password);


}
