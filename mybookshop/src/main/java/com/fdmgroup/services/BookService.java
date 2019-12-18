package com.fdmgroup.services;

import java.util.Optional;

import com.fdmgroup.models.Book;

public interface BookService {
	public Book addBook(Book newBook);

	public void deleteABook(Long id);

	public Book findBookByTitle(String title);

	public Iterable<Book> getAllBooks();
	
	public Optional<Book> findById(Long id);
	
	public Iterable<Book> findBooksByTitle(String title);

	
}
