package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDaoConnection {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/library", "postgres",
					"admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
