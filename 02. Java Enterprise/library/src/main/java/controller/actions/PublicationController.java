package controller.actions;

import java.util.List;

import services.PublicationService;
import services.exceptions.GenericDBException;
import services.exceptions.IsbnExistsException;
import services.exceptions.IssnExistsException;
import services.exceptions.NoSuchIdException;
import application.LibraryApp;
import entities.Publication;

public class PublicationController {

	private PublicationService publicationService = new PublicationService();

	public void listOptions() {
		System.out.println("1. List registered publications");
		System.out.println("2. Register book");
		System.out.println("3. Register magazine");
		System.out.println("4. Update book");
		System.out.println("5. Update magazine");
		System.out.println("6. Unregister publication");
		System.out.println("7. Exit");
	}

	public void listPublications() {
		try {
			List<Publication> list = publicationService.getPublications();
			for (Publication p : list) {
				System.out.println(p);
			}
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		}
	}

	public void registerBook() {
		try {
			System.out.println("Enter ISBN:");
			String isbn = LibraryApp.in.next();
			System.out.println("Enter title:");
			String title = LibraryApp.in.next();
			publicationService.registerBook(isbn, title);
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		} catch (IsbnExistsException e) {
			LibraryApp.logger.log("ISBN already exists!");
		}
	}

	public void registerMagazine() {
		try {
			System.out.println("Enter ISSN:");
			String issn = LibraryApp.in.next();
			System.out.println("Enter title:");
			String title = LibraryApp.in.next();
			publicationService.registerMagazine(issn, title);
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		} catch (IssnExistsException e) {
			LibraryApp.logger.log("ISSN already exists!");
		}
	}

	public void updateBook() {
		try {
			System.out.println("Enter ID:");
			long id = Long.parseLong(LibraryApp.in.next());
			System.out.println("Enter new ISBN:");
			String isbn = LibraryApp.in.next();
			System.out.println("Enter new title:");
			String title = LibraryApp.in.next();
			publicationService.updateBook(id, isbn, title);

		} catch (NumberFormatException e) {
			LibraryApp.logger.log("Insert number for ID!");
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		} catch (IsbnExistsException e) {
			LibraryApp.logger.log("ISBN already exists!");
		} catch (NoSuchIdException e) {
			LibraryApp.logger.log("No such book ID!");
		}
	}

	public void updateMagazine() {
		try {
			System.out.println("Enter ID:");
			long id = Long.parseLong(LibraryApp.in.next());
			System.out.println("Enter new ISSN:");
			String issn = LibraryApp.in.next();
			System.out.println("Enter new title:");
			String title = LibraryApp.in.next();
			publicationService.updateMagazine(id, issn, title);

		} catch (NumberFormatException e) {
			LibraryApp.logger.log("Insert number for ID!");
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		} catch (IssnExistsException e) {
			LibraryApp.logger.log("ISSN already exists!");
		} catch (NoSuchIdException e) {
			LibraryApp.logger.log("No such magazine ID!");
		}
	}

	public void unregisterPublication() {
		try {
			System.out.println("Enter ID:");
			long id = Long.parseLong(LibraryApp.in.next());
			publicationService.unregisterPublication(id);
		} catch (NumberFormatException e) {
			LibraryApp.logger.log("Insert number for ID!");
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		} catch (NoSuchIdException e) {
			LibraryApp.logger.log("No such publication ID!");
		}
	}
}
