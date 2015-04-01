package dao;

import java.util.List;

public interface Dao {

	public List getBooks();

	public boolean registerBook(String isbn, String title);

	public boolean updateBook(String title, String isbn);
	
	public boolean unregisterBook(String title);

}
