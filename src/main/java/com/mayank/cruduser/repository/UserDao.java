package com.mayank.cruduser.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.mayank.cruduser.entity.User;

public interface UserDao extends ElasticsearchRepository<User, String> {
		
	List<User> findByFirstname(String firstName);
		
}
