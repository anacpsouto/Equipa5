package com.upt.donations.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipments")
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotBlank(message = "Equipment name is required.")
	private String name;

	@Column(nullable = false)
	private String category;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToMany(mappedBy = "equipments")
	private Set<Donation> donations = new HashSet<>();

	public Equipment() {
	}

	public Equipment(String name, String category, User user) {
		this.name = name;
		this.category = category;
		this.user = user;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Donation> getDonations() {
		return donations;
	}

	public void setDonations(Set<Donation> donations) {
		this.donations = donations;
	}

	@Override
	public String toString() {
		return "Equipment ID: " + getId() + ", Name: " + getName() + ", Category: " + getCategory() + ", Donor: "
				+ getUser().getName();
	}
}
