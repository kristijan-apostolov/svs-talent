import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.event.ListSelectionEvent;

import library.Book;
import library.Library;
import dao.Dao;
import dao.HibernateDao;
import dao.JdbcDao;
import dao.JdbcDaoConnection;

public class LibraryApplication {

	public static void menu() {
		System.out.println("[1] Register book");
		System.out.println("[2] List registered books");
		System.out.println("[3] Update book registration");
		System.out.println("[4] Unregister books"); // delete books
		System.out.println("[5] Exit");
	}

	public static Library getLibrary(int choise) {
		Library library = null;
		// make a choise JDBC or Hibernate

		if (choise == 0) {
			library = new Library(new JdbcDao());
		} else {
			library = new Library(new HibernateDao());
		}
		return library;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// 0 - Jdbc 1 - Hibernate
		int choise = 1;
		Library library = getLibrary(choise);

		menu();
		int n = -1;
		while (n != 5) {

			n = input.nextInt();

			switch (n) {
			case 0:
				menu();
				break;
			case 1:
				System.out.println("insert isbn");
				String isbn = input.next();
				System.out.println("insert title");
				String title = input.next();
				if (library.registerBook(isbn, title)) {
					System.out.println("book registered");
				}
				System.err.println("[0] Show menu");
				break;
			case 2:
				List list = library.getBooks();
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).toString());
				}
				System.err.println("[0] Show menu");
				break;
			case 3:
				// change title
				System.out.println("insert isbn");
				String isbn1 = input.next();
				System.out.println("insert new title");
				String title1 = input.next();
				if (library.updateBook(title1, isbn1)) {
					System.out.println("book updated");
				}
				System.err.println("[0] Show menu");
				break;
			case 4:
				System.out.println("insert isbn or title");
				String s = input.next();
				if(library.unregisterBook(s)){
					System.out.println("book deleted");
				}
				System.err.println("[0] Show menu");
				break;
			case 5:

				break;
			case 6:

				break;
			}
		}
	}
}
