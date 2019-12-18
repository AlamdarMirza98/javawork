package com.fdmgroup.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Name is required.")
	@Size(min = 2, max = 100, message = "Name should be between 2 to 100 characters.")
	private String name;

	@Column(unique = true, updatable = false)
	@NotBlank(message = "Email is required")
	@Email(regexp = "([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)", message = "Please insert valid email.")
	private String email;

	@NotBlank(message = "Phone number is required.")
	@Size(min = 5, max = 5, message = "Incorrect phone number.")
	private String phone;

	@ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
	private Set<Book> books = new HashSet<Book>();

	public Author(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

}
