package com.fdmgroup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	public Author findByEmail(String email);
	public void deleteByEmail(String email);
}
