package dao;

import library.Book;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateDaoConnection {

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory sessionFactory = configuration.addAnnotatedClass(
				Book.class).buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
}
