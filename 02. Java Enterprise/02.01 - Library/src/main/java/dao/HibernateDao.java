package dao;

import java.util.List;

import library.Book;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateDao implements Dao {

	SessionFactory sessionFactory;

	public HibernateDao() {
		this.sessionFactory = HibernateDaoConnection.getSessionFactory();
	}

	public List getBooks() {

		Session session = sessionFactory.openSession();
		String hql = "FROM Book";
		Query query = session.createQuery(hql);
		List results = query.list();
		return results;
	}

	public boolean registerBook(String isbn, String title) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book = new Book();
			book.setIsbn(isbn);
			book.setTitle(title);
			session.save(book);
			tx.commit();
			return true;

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;

		} finally {
			session.close();
		}

	}

	public boolean updateBook(String title, String isbn) {

		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			String hql = "UPDATE Book set title = :title WHERE isbn = :isbn";

			Query query = session.createQuery(hql);
			query.setParameter("title", title);
			query.setParameter("isbn", isbn);
			query.executeUpdate();

			tx.commit();
			return true;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;

		} finally {
			session.close();
		}

	}

	public boolean unregisterBook(String title) {

		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Query q = session.createQuery("DELETE Book where title = :title");
			q.setParameter("title", title);
			q.executeUpdate();

			tx.commit();
			return true;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;

		} finally {
			session.close();
		}

	}

}
