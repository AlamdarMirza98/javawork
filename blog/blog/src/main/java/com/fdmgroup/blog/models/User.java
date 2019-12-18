package com.fdmgroup.blog.models;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// jpa - java persistent api
// @entity converts model class to a database table
// table name is optional
// @entity means table in the database

@Entity 
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private UUID userId = UUID.randomUUID();
	private LocalDate createdAt;
	private LocalDate updatedAt;
	@NotBlank(message = "Name is Required.")
	@Size(min = 2, max = 150, message = "Please insert name between 2-100 characters")
	private String name;
	@Email(regexp = "([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)", message = "Please insert valid email")
	private String email;
	@NotBlank(message = "Password is Required.")
	@Size(min = 8, max = 100, message = "Please insert password between 8-100 characters")
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password) {
		this.userId = getUserId();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UUID getUserId() {
		return UUID.randomUUID();
	}


	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	private void createdAt() {
		this.createdAt = LocalDate.now();
	}

	@PreUpdate
	private void updateAt() {
		this.updatedAt = LocalDate.now();
	}

}
