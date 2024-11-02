package doacoes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EquipamentosManager {
	protected SessionFactory sessionFactory;
	GerirUtilizador g = new GerirUtilizador();

	protected void setup() {
	// code to load Hibernate Session factory
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
				try {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
				} catch (Exception ex) {
				StandardServiceRegistryBuilder.destroy(registry);
				}
	}
	
	protected void exit() {
	// code to close Hibernate Session factory
		
		sessionFactory.close();
	}
	
	protected void create(String email, String pass, Equipamento equipamento) {
	// code to save a book
		//Utilizador u = g.pesquisar(email, pass);
        //if (u != null) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.persist(equipamento);
		
		session.getTransaction().commit();
		System.out.println("Pronto!");
		session.close();
       // }
	}
	protected void read() {
	// code to get a book
	}
	protected void update() {
	// code to modify a book
	}
	protected void delete() {
	// code to remove a book
	}
	
}
