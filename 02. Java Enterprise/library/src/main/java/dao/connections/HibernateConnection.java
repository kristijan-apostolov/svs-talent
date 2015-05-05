package dao.connections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entities.BaseEntity;
import entities.Book;
import entities.Loan;
import entities.Magazine;
import entities.Member;
import entities.Membership;
import entities.Publication;

public class HibernateConnection {

	private static SessionFactory sessionFactory = null;

	public static void createSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.addAnnotatedClass(BaseEntity.class)
					.addAnnotatedClass(Publication.class)
					.addAnnotatedClass(Book.class)
					.addAnnotatedClass(Magazine.class)
					.addAnnotatedClass(Loan.class)
					.addAnnotatedClass(Member.class)
					.addAnnotatedClass(Membership.class)
					.buildSessionFactory(serviceRegistry);
		}
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}

	public static Session createSession() {
		return sessionFactory.openSession();
	}
}
