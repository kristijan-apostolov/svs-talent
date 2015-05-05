package dao;
/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.connections.JDBCConnection;
import entities.Book;
import exceptions.GenericDBException;
import exceptions.IsbnExistsException;
import exceptions.NoSuchIdException;

public class JDBCBookDAO implements BookDAO{

	public ArrayList<Book> getBooks() {
		ArrayList<Book> books = new ArrayList<Book>();

		try {
			Connection connection = JDBCConnection.getLibraryConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM book");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				books.add(new Book(resultSet.getInt("id"), resultSet
						.getString("isbn"), resultSet.getString("title")));
			}

			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			throw new GenericDBException();
		}

		return books;
	}

	public void registerBook(String isbn, String title) {
		try {
			Connection connection = JDBCConnection.getLibraryConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO book (isbn, title) VALUES (?, ?)");
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, title);

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			throw new GenericDBException();
		}
	}

	public void updateBook(int id, String isbn, String title)
			throws NoSuchIdException {
		try {
			Connection connection = JDBCConnection.getLibraryConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE book SET isbn=?,title=? WHERE id=?");
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, title);
			preparedStatement.setInt(3, id);

			int result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			if (result == 0) {
				throw new NoSuchIdException();
			}
		} catch (SQLException e) {
			throw new GenericDBException();
		}
	}

	public void unregisterBook(int id) throws NoSuchIdException {
		try {
			Connection connection = JDBCConnection.getLibraryConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM book WHERE id=?");
			preparedStatement.setInt(1, id);

			int result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			if (result == 0) {
				throw new NoSuchIdException();
			}
		} catch (SQLException e) {
			throw new GenericDBException();
		}
	}

	public void checkISBN(String isbn) throws IsbnExistsException {
		try {
			Connection connection = JDBCConnection.getLibraryConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM book WHERE isbn=?");
			preparedStatement.setString(1, isbn);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				throw new IsbnExistsException();
			}
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			throw new GenericDBException();
		}
	}

}
*/