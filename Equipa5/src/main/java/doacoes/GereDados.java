package doacoes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class GereDados {

	protected SessionFactory sessionFactory;

	protected void setup() {
		// code to load Hibernate Session factory
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings																				
																									// hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
		}

	}

	/*protected void exit() {
		// code to close Hibernate Session factory
		
	}*/

	protected void create(Object object) {
		// code to save a book
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.persist(object);
		
		session.getTransaction().commit();
		session.close();


	}

	protected Utilizador read(int id) {
		// code to get a book
		setup();
		Session session = sessionFactory.openSession();
		
		Utilizador utilizador = session.createQuery("from Utilizador u where u.id = :id", Utilizador.class)
							.setParameter("id", id)
							.getSingleResult();
		session.close();
		return utilizador;
	}

	protected void updatePassword(int id, String newPassword) {
		// code to modify a book
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Utilizador u = session.get(Utilizador.class, id);
		u.setPassword(newPassword);
		
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	protected void updateEmail() {
		// code to modify a book
		
	}

	protected void delete(Object object) {
		// code to remove a book
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.remove(object);
		
		session.getTransaction().commit();
		session.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GereDados gere = new GereDados();
		Utilizador u = new Utilizador("ana@gmail.com", "Euana2001");
		
		gere.create(u);
	}

}
