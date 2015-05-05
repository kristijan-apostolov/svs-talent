package aliexpress.dataaccess.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public static Connection getLibraryConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/aliexpress", "postgres",
				"postgres");
	}
}
