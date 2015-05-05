package aliexpress.dataaccess.warehouse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import aliexpress.dataaccess.connections.ProductParser;
import aliexpress.model.Product;
import aliexpress.services.exceptions.GenericDBException;

public class InMemoryWarehouse implements Warehouse {

	@Override
	public List<Product> getProducts() {
		List<Product> products;
		try {
			products = ProductParser.getProducts();
		} catch (FileNotFoundException e) {
			throw new GenericDBException();
		} catch (IOException e) {
			throw new GenericDBException();
		}
		return products;
	}

	@Override
	public Product getProduct(String key) {
		List<Product> products = getProducts();
		for (Product product : products) {
			if (key.equals(product.getKey())) {
				return product;
			}
		}
		return null;
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
