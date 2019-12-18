package com.fdmgroup.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	public Book findByTitle(String title);
	
	public Iterable<Book> findAllByTitle(String title);
}
