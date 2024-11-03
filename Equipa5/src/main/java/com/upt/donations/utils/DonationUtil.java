package com.upt.donations.utils;

import com.upt.donations.model.Donation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DonationUtil {

	public void saveDonation(Donation donation) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(donation);
			transaction.commit();
			System.out.println("Donation registered successfully!");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Donation> getDonationsByUserId(Long donorId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM Donation WHERE donor.id = :donorId", Donation.class)
					.setParameter("donorId", donorId).list();
		}
	}

	public List<Donation> getAllDonations() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM Donation", Donation.class).list();
		}
	}
}
