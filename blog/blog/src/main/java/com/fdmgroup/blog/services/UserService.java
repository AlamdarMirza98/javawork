package com.fdmgroup.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.blog.models.User;
import com.fdmgroup.blog.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	//user will be saved by user repository to database
	public User addUser(User newUser) {
		return this.userRepository.save(newUser);
		
	}
	
	//user repository asks to get all the users in the database 
	public List<User> getAllUsers(){
	return this.userRepository.findAll();
	}
	
	//the user repository asks the table if it has a email that matches
	//then returns that object
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	
	public void delete(String email) {
		User user = this.findByEmail(email);
		this.userRepository.delete(user);
	}
}

