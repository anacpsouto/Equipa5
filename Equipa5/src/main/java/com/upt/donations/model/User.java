package com.upt.donations.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotBlank(message = "Name is required.")
	private String name;

	@Column(nullable = false, unique = true)
	@Email(message = "Email should be valid!")
	private String email;

	@Column(nullable = false)
	@NotBlank(message = "Password is required.")
	@Size(min = 6, message = "Password must be at least 6 characters long.")
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserType userType;

	public User() {
	}

	public User(String name, String email, String password, UserType userType) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
