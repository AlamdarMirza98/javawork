package com.fdmgroup.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fdmgroup.blog.models.User;

//User repository is the child of jpa repository which means it will have for free pre-perpaid methods such as save, find by... 

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

}
