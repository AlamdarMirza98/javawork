package com.fdmgroup.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fdmgroup.blog.models.User;
import com.fdmgroup.blog.repositories.UserRepository;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;	

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception{

		User user = new User("James Bond", "jd@msn.com","abcd1234");
		this.userRepository.save(user);
		
	}
}
