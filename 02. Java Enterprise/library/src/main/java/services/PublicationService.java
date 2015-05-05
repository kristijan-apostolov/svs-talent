package services;

import java.util.List;
import services.exceptions.IsbnExistsException;
import services.exceptions.IssnExistsException;
import services.exceptions.NoSuchIdException;
import dao.DAO;
import dao.HibernateBookDAO;
import dao.HibernateMagazineDAO;
import dao.HibernatePublicationDAO;
import entities.Book;
import entities.Magazine;
import entities.Publication;

@SuppressWarnings("unchecked")
public class PublicationService {

	private DAO bookDAO = new HibernateBookDAO();
	private DAO magazineDAO = new HibernateMagazineDAO();
	private DAO publicationDAO = new HibernatePublicationDAO();

	public List<Publication> getPublications() {
		return publicationDAO.getAll();
	}

	public void registerBook(String isbn, String title)
			throws IsbnExistsException {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		Validator.checkISBN(bookDAO.getAll(), book);
		bookDAO.insert(book);
	}

	public void registerMagazine(String issn, String title)
			throws IssnExistsException {
		Magazine magazine = new Magazine();
		magazine.setIssn(issn);
		magazine.setTitle(title);
		Validator.checkISSN(magazineDAO.getAll(), magazine);
		magazineDAO.insert(magazine);
	}

	public void updateBook(long id, String isbn, String title)
			throws IsbnExistsException, NoSuchIdException {
		Book book = new Book();
		book.setId(id);
		book.setIsbn(isbn);
		book.setTitle(title);
		if (bookDAO.get(id) == null) {
			throw new NoSuchIdException();
		}
		Validator.checkISBN(bookDAO.getAll(), book);
		bookDAO.update(book);
	}

	public void updateMagazine(long id, String issn, String title)
			throws NoSuchIdException, IssnExistsException {
		Magazine magazine = new Magazine();
		magazine.setId(id);
		magazine.setIssn(issn);
		magazine.setTitle(title);
		if (magazineDAO.get(id) == null) {
			throw new NoSuchIdException();
		}
		Validator.checkISSN(magazineDAO.getAll(), magazine);
		magazineDAO.update(magazine);
	}

	public void unregisterPublication(long id) throws NoSuchIdException {
		Publication publication = (Publication) publicationDAO.get(id);
		if (publication == null) {
			throw new NoSuchIdException();
		}
		publicationDAO.delete(publication);
	}

}
