package dao.templates;

import org.hibernate.Session;
import org.hibernate.Transaction;

import services.exceptions.GenericDBException;
import dao.connections.HibernateConnection;

public class HibernateTemplate {

	public <T> T returnQuery(HibernateGetSetter hibernateGetSetter) {
		Session session = HibernateConnection.createSession();
		T object = hibernateGetSetter.returnQuery(session);
		session.close();
		return object;
	}

	public void makeTransaction(HibernateCommitSetter hibernateCommitSetter) {
		Session session = HibernateConnection.createSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			hibernateCommitSetter.makeTransaction(session);

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new GenericDBException();
		} finally {
			session.close();
		}
	}
}
