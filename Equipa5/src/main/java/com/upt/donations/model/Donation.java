package com.upt.donations.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "donations")
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Enumerated(EnumType.STRING)
	private DonationStatus status;

	private String evaluation;

	@ManyToOne
	@JoinColumn(name = "donor_id", nullable = false)
	private User donor;

	@ManyToMany
	@JoinTable(name = "donation_equipments", joinColumns = @JoinColumn(name = "donation_id"), inverseJoinColumns = @JoinColumn(name = "equipment_id"))
	private Set<Equipment> equipments = new HashSet<>();

	public Donation() {
	}

	public Donation(Date date, DonationStatus status, User donor) {
		this.date = date;
		this.status = status;
		this.donor = donor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DonationStatus getStatus() {
		return status;
	}

	public void setStatus(DonationStatus status) {
		this.status = status;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public User getDonor() {
		return donor;
	}

	public void setDonor(User donor) {
		this.donor = donor;
	}

	public Set<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(Set<Equipment> equipment) {
		this.equipments = equipment;
	}

	@Override
	public String toString() {
		return "Donation ID: " + getId() + ", Date: " + getDate() + ", Donor: " + getDonor().getName() + ", Status: "
				+ getStatus() + ", Evaluation: " + getEvaluation();
	}
}