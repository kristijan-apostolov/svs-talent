package library;

import java.util.List;

import dao.Dao;
import dao.HibernateDao;

public class Library {

	private Dao dao;

	public Library(Dao dao) {
		this.dao = dao;
	}

	public List getBooks() {
		return this.dao.getBooks();
	}

	public boolean registerBook(String isbn, String title) {
		return this.dao.registerBook(isbn, title);
	}

	public boolean updateBook(String title, String isbn) {
		return this.dao.updateBook(title, isbn);
	}

	public boolean unregisterBook(String title) {
		return this.dao.unregisterBook(title);
	}

}
