package com.fdmgroup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.models.Author;
import com.fdmgroup.models.Book;
import com.fdmgroup.services.AuthorService;
import com.fdmgroup.services.BookService;

@Controller
public class BookController {
	private BookService bookService;
	private AuthorService authorService;

	public BookController(BookService bookService, AuthorService authorService) {
		this.bookService = bookService;
		this.authorService = authorService;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register(ModelMap map) {
		Iterable<Author> authors = this.authorService.getAllAuthors();
		map.addAttribute("authors", authors);
		return "register";
	}
	
	@PostMapping("/register")
	public String register(
			@RequestParam String title,  
			@RequestParam double price, 
			@RequestParam String email,
			ModelMap map) {
		Book newBook = new Book(title,price);
		Author author = this.authorService.findAuthorByEmail(email);
		newBook.addAuthor(author);
		this.bookService.addBook(newBook);
		Iterable<Book> result = this.bookService.getAllBooks();
		map.addAttribute("books", result);
		map.addAttribute("author", author);
		return "all-books";
	}
	
	@GetMapping("/all-books")
	public String getAllBooks(ModelMap map) {
		Iterable<Book> result = this.bookService.getAllBooks();
		map.addAttribute("books", result);
		return "all-books";
	}
	
	@GetMapping("/delete")
	public String deleteBook(@RequestParam Long id,ModelMap map) {
		this.bookService.deleteABook(id);
		Iterable<Book> result = this.bookService.getAllBooks();
		map.addAttribute("books", result);
		return "all-books";
	}
	
	@GetMapping("/edit")
	public String updateBook(@RequestParam Long id, ModelMap map) {
		Book book = this.bookService.findById(id).get();
		map.addAttribute("book", book);
		return "edit-book";
	}
	
	@PostMapping("/edit")
	public String updateBook(@RequestParam Long id, 
			@RequestParam String title,
			@RequestParam String author,
			@RequestParam double price, ModelMap map) {
		Book book = new Book(title, price);
		book.setId(id);
		this.bookService.addBook(book);
		Iterable<Book> books = this.bookService.getAllBooks();
		map.addAttribute("books", books);
		return "all-books";
	}
	
	@GetMapping("/search")
	public String searchBook(@RequestParam String title, ModelMap map) {
		Iterable<Book> books = this.bookService.findBooksByTitle(title);
		map.addAttribute("books", books);
		return "search";
	}
	

}
