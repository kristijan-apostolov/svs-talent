package aliexpress.dataaccess.connections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import aliexpress.model.Account;
import aliexpress.model.BaseEntity;
import aliexpress.model.CreditCard;
import aliexpress.model.Product;

public class HibernateConnection {

	private static SessionFactory sessionFactory = null;

	public static void createSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.addAnnotatedClass(Product.class)
					.addAnnotatedClass(BaseEntity.class)
					.addAnnotatedClass(Account.class)
					.addAnnotatedClass(CreditCard.class)
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
