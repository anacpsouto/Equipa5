package com.upt.donations.utils;

import com.upt.donations.model.User;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;

public class UserUtil {

	public UserUtil() {
	}

	public void registerUser(User user) {
		Set<ConstraintViolation<User>> violations = HibernateUtil.getValidator().validate(user);

		if (!violations.isEmpty()) {
			for (ConstraintViolation<User> violation : violations) {
				System.out.println("Validation error: " + violation.getMessage());
			}
			return;
		}

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(user);
			transaction.commit();
			System.out.println("User registered successfully!");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public User authenticateUser(String email, String password) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<User> query = session.createQuery("FROM User WHERE email = :email AND password = :password",
					User.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			return query.uniqueResult();
		}
	}

	public User findUserById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public User searchUserByName(String userName) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<User> query = session.createQuery("FROM User WHERE name LIKE :userName", User.class);
			query.setParameter("userName", "%" + userName + "%");
			return query.uniqueResult();
		}
	}
}
