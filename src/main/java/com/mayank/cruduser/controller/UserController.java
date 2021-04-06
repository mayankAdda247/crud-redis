package com.mayank.cruduser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.cruduser.repository.UserDao;
import com.mayank.cruduser.entity.User;

/*@RestController
@RequestMapping("/api/users/")
public class UserController {
	
	@Autowired
	private  UserRepository userRepository;
	
	//get all users
	@GetMapping
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
		
	}
	
	//get user by id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") long userId)
	{
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with a user id "+ userId));

	}
	//create user
	@PostMapping
	public User createUser(@RequestBody User user)
	{
		return this.userRepository.save(user);
	}
	//update by id 
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user,@PathVariable(value = "id") long userId)
	{
		User existingUser =this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with a user id "+ userId));
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setOccupation(user.getOccupation());
		existingUser.setState(user.getState());
		return this.userRepository.save(existingUser);
		 
	}
	//delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id") long userId)
	{
		User existingUser =this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with a user id "+ userId));
		
		this.userRepository.delete(existingUser);
		return ResponseEntity.ok().build();
	}
}*/

@RestController
@RequestMapping("/api/users/")
@EnableCaching
public class UserController {
	
	@Autowired
	private  UserDao dao;
	
	@PostMapping("/saveUser")
	public int saveUser(@RequestBody List<User> users) {
		dao.saveAll(users);
		return users.size();
	}

	@GetMapping("/findAll")
	public Iterable<User> findAllUsers() {
		return dao.findAll();
	}

	@GetMapping("/findByFName/{firstName}")
	public List<User> findByFirstName(@PathVariable String firstName) {
		return dao.findByFirstname(firstName);
	}
	//get all users
	/*@GetMapping
	public List<User> getAllUsers(){
		return this.dao.findAll();
		
	}
	
	//get user by id
	
	
	@GetMapping("/{id}")
	@Cacheable(key="#userId", value="User")
	public User getUserById(@PathVariable(value = "id") long userId)
	{	
		return this.dao.findUserById(userId);

	}
	//create user
	@PostMapping
	public User createUser(@RequestBody User user)
	{
		return this.dao.save(user);
	}
	
	//delete user by id
	@DeleteMapping("/{id}")
	@CacheEvict(key="#userId", value="User")
	public String deleteUser(@PathVariable(value = "id") long userId)
	{
		
		return dao.deleteUser(userId);
	}*/
}
