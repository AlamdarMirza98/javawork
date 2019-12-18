package com.fdmgroup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.models.Author;
import com.fdmgroup.models.Book;
import com.fdmgroup.services.AuthorService;

@Controller
public class AuthorController {
	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	// display the author registration form
	@GetMapping("/add-author")
	public String addAuthor() {
		return "add-author";
	}

	// grap the author details from the add-author registration form and the author
	@PostMapping("/add-author")
	public String addAuthor(@RequestParam String name, @RequestParam String email, @RequestParam String phone,
			ModelMap map) {
		Author author = new Author(name, email, phone);
		this.authorService.addAuthor(author);
		Iterable<Author> authors = this.authorService.getAllAuthors();
		map.addAttribute("authors", authors);
		return "all-authors";
	}

	@GetMapping("/all-authors")
	public String getAllAuthors(ModelMap map) {
		Iterable<Author> authors = this.authorService.getAllAuthors();
		map.addAttribute("authors", authors);
		return "all-authors";
	}
	
	@GetMapping("/delete-authors")
	public String deleteAuthor(@RequestParam String email,ModelMap map) {
		this.authorService.deleteAuthor(email);
		Iterable<Author> result = this.authorService.getAllAuthors();
		map.addAttribute("authors", result);
		return "all-authors";

	}
	
	@GetMapping("/edit-author")
	public String updateAuthor(@RequestParam String email, ModelMap map) {
		Author author = this.authorService.findAuthorByEmail(email);
		map.addAttribute("author", author);
		return "edit-author";
		
	}
	
		@PostMapping("/edit-authors")
		public String updateAuthor(@RequestParam Long id, 
				@RequestParam String Name,
				@RequestParam String email,
				@RequestParam String phone, ModelMap map) {
			Author author = new Author(Name, email, phone);
			author.setId(id);
			this.authorService.addAuthor(author);
			Iterable<Author> authors = this.authorService.getAllAuthors();
			map.addAttribute("authors", authors);
			return "all-authors";
		}
	
	
		
	
	

}
