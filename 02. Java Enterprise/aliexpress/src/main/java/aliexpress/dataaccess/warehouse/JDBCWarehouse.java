package aliexpress.dataaccess.warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aliexpress.dataaccess.templates.JDBCGetSetter;
import aliexpress.dataaccess.templates.JDBCTemplate;
import aliexpress.model.Product;

public class JDBCWarehouse implements Warehouse {

	@Override
	public List<Product> getProducts() {

		return new JDBCTemplate().returnQuery(new JDBCGetSetter() {

			@Override
			@SuppressWarnings("unchecked")
			public List<Product> returnQuery(Connection connection)
					throws SQLException {
				ArrayList<Product> products = new ArrayList<Product>();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM product");
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					products.add(new Product(resultSet.getString("key"),
							resultSet.getString("name"), resultSet
									.getInt("price"), resultSet
									.getInt("quantity")));
				}
				preparedStatement.close();
				return products;
			}

		});

	}

	@Override
	public Product getProduct(final String key) {

		return new JDBCTemplate().returnQuery(new JDBCGetSetter() {

			@Override
			@SuppressWarnings("unchecked")
			public Product returnQuery(Connection connection)
					throws SQLException {
				Product product = null;
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM product WHERE key=?");
				preparedStatement.setString(1, key);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					product = new Product(resultSet.getString("key"), resultSet
							.getString("name"), resultSet.getInt("price"),
							resultSet.getInt("quantity"));
				}
				preparedStatement.close();
				return product;
			}

		});

	}

	@Override
	public void update(Product product) {
		// no longer supported
	}

	@Override
	public void insert(Product product) {
		// no longer supported
	}

	@Override
	public void delete(Product product) {
		// no longer supported
	}

}
