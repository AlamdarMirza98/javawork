package com.fdmgroup.services;

import com.fdmgroup.models.Author;

public interface AuthorService {
	public Author addAuthor(Author author);
	public Author findAuthorByEmail(String email);
	public void  deleteAuthor(String email);
	public Iterable<Author> getAllAuthors();
}
