package com.fdmgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fdmgroup.models.Author;
import com.fdmgroup.models.Book;
import com.fdmgroup.services.AuthorService;
import com.fdmgroup.services.BookService;

@SpringBootApplication
public class MybookshopApplication implements CommandLineRunner {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;

	public static void main(String[] args) {
		SpringApplication.run(MybookshopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book = new Book("Java Introduction", 20.99);
		Book book1 = new Book("HTML Introduction", 20.99);
		Book book2 = new Book("Spring Framework", 20.99);
		
		Author author = new Author("John Doe", "jd@msn.com", "11111");
		Author author1 = new Author("Mesut Adiguzel", "mesut@msn.com", "11111");
		Author author2 = new Author("Adam Smith", "ada@msn.com", "11111");
		
		
		book.addAuthor(author);
		book1.addAuthor(author1);
		book2.addAuthor(author1);
		
		
		bookService.addBook(book);
		bookService.addBook(book1);
		bookService.addBook(book2);
		
		authorService.addAuthor(author);
		authorService.addAuthor(author1);
		authorService.addAuthor(author2);
		
	}

}
