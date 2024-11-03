package com.upt.donations.utils;

import com.upt.donations.model.Equipment;
import com.upt.donations.model.User;
import jakarta.validation.ConstraintViolation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class EquipmentUtil {
	public void saveEquipment(Equipment equipment) {
		Set<ConstraintViolation<Equipment>> violations = HibernateUtil.getValidator().validate(equipment);

		if (!violations.isEmpty()) {
			for (ConstraintViolation<Equipment> violation : violations) {
				System.out.println("Validation error: " + violation.getMessage());
			}
			return;
		}

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(equipment);
			transaction.commit();
			System.out.println("Equipment added successfully!");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Equipment> searchEquipments(String name) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Equipment> query = session.createQuery("FROM Equipment WHERE name LIKE :name", Equipment.class);
			query.setParameter("name", "%" + name + "%");
			List<Equipment> equipmentList = query.list();
			return equipmentList;
		}
	}

	public Equipment findEquipmentById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Equipment.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateEquipment(Equipment equipment) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(equipment);
			transaction.commit();
			System.out.println("Equipment updated successfully!");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteEquipment(Equipment equipment) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.delete(equipment);
			transaction.commit();
			System.out.println("Equipment deleted successfully!");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
