package dao.templates;

import java.sql.Connection;
import java.sql.SQLException;

public interface JDBCGetSetter {

	<T> T returnQuery(Connection connection) throws SQLException;
}
