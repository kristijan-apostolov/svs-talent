package dao.templates;

import java.sql.Connection;
import java.sql.SQLException;

import services.exceptions.GenericDBException;
import dao.connections.JDBCConnection;

public class JDBCTemplate {

	public <T> T returnQuery(JDBCGetSetter jdbcGetSetter) {
		try {
			Connection connection = JDBCConnection.getLibraryConnection();
			T object = jdbcGetSetter.returnQuery(connection);
			connection.close();
			return object;
		} catch (SQLException e) {
			throw new GenericDBException();
		}
	}

}
