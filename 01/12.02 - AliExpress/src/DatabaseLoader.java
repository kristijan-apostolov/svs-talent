import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DatabaseLoader implements Loader {

	HashMap<String, Product> products;
	Connection connection;

	public DatabaseLoader(String url, String userName, String password) {
		products = new HashMap<>();
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public HashMap<String, Product> load() {
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select * from products");
			while (resultSet.next()) {
				String key = resultSet.getString("key");
				String name = resultSet.getString("name");
				Double price = resultSet.getDouble("price");
				Integer quantity = resultSet.getInt("quantity");
				products.put(key, new Product(key, name, price, quantity));

			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

}
