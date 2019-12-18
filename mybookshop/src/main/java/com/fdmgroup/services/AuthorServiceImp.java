package com.fdmgroup.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fdmgroup.models.Author;
import com.fdmgroup.repositories.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImp implements AuthorService {

	private AuthorRepository authorRepository;

	public AuthorServiceImp(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public Author addAuthor(Author author) {
		return this.authorRepository.save(author);
	}

	@Override
	public Author findAuthorByEmail(String email) {
		return this.authorRepository.findByEmail(email);
	}

	@Override
	public void deleteAuthor(String email) {
		this.authorRepository.deleteByEmail(email);
	}

	@Override
	public Iterable<Author> getAllAuthors() {
		return this.authorRepository.findAll();
	}

}
