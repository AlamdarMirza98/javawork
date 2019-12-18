package com.fdmgroup.blog.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.blog.models.User;
import com.fdmgroup.blog.services.UserService;

@RestController 
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/users")
	public ResponseEntity<User>registerUser(@Valid @RequestBody User user, BindingResult bindingResult){
	Map<String, String> validationErrors = new HashMap<String, String>();
	if(bindingResult.hasErrors()) {
		for (FieldError error : bindingResult.getFieldErrors()) {
			
		validationErrors.put(error.getField(), error.getDefaultMessage());
	
		User createdUser = this.userService.addUser(user);
		return new ResponseEntity<User>(createdUser,HttpStatus.BAD_REQUEST);
	}
}
	}

	// the RequestBody will capture the details entered into a registration form and enters it into a DB.
	@PostMapping("/api/users")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user, BindingResult bindResult) {
		User createdUser = this.userService.addUser(user);
		return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
	}
	
	@GetMapping ("/api/users")
	public ResponseEntity<List <User>> getAllUsers(){
		List<User> allUsers = this.userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
	}
	
	@DeleteMapping("/api/books/{email}")
	public ResponseEntity<?> deleteUser(@PathVariable String email){
		this.userService.delete(email);
		return new ResponseEntity(HttpStatus.GONE);
	}
}
