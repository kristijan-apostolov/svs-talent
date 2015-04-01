package dao;

import library.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDao implements Dao {

	Connection connection;

	public JdbcDao() {
		this.connection = JdbcDaoConnection.getConnection();
	}

	public List getBooks() {
		List<Book> list = new ArrayList<Book>();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from book");
			while (resultSet.next()) {
				list.add(new Book(resultSet.getInt("id"), resultSet
						.getString("isbn"), resultSet.getString("title")));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean registerBook(String isbn, String title) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into book(isbn, title) values (?, ?)");

			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, title);
			preparedStatement.executeUpdate();

			preparedStatement.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateBook(String title, String isbn) {

		PreparedStatement ps;
		try {
			ps = connection
					.prepareStatement("UPDATE book SET title = ? WHERE isbn = ?");
			ps.setString(1, title);
			ps.setString(2, isbn);

			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean unregisterBook(String title) {
		PreparedStatement ps;
		try {
			ps = connection
					.prepareStatement("DELETE FROM book WHERE title = ?");
			ps.setString(1, title);

			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
