package com.fdmgroup.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fdmgroup.models.Book;
import com.fdmgroup.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
//	@Autowired
	private BookRepository bookRepository;

	// please dont use autowire youse constructors from now on
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book addBook(Book newBook) {
		return this.bookRepository.save(newBook);
	}

	@Override
	public void deleteABook(Long id) {
		this.bookRepository.deleteById(id);
	}

	@Override
	public Book findBookByTitle(String title) {
		return this.bookRepository.findByTitle(title);
	}

	@Override
	public Iterable<Book> getAllBooks() {
		return this.bookRepository.findAll();
	}

	@Override
	public Optional<Book> findById(Long id) {
		return this.bookRepository.findById(id);
	}

	@Override
	public Iterable<Book> findBooksByTitle(String title) {
		return this.bookRepository.findAllByTitle(title);
	}

}
