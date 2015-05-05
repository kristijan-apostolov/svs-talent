package aliexpress.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aliexpress.dataaccess.warehouse.Warehouse;
import aliexpress.model.Product;
import aliexpress.services.exceptions.NoSuchKeyException;
import aliexpress.services.exceptions.NotEnoughQuantityException;

@Service
public class WarehouseService {

	private Warehouse warehouse;

	@Autowired
	public WarehouseService(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public List<Product> getProducts() {
		return warehouse.getProducts();
	}

	public Product getProduct(String key, int qty)
			throws NotEnoughQuantityException, NoSuchKeyException {
		Product product = warehouse.getProduct(key);
		if (product == null) {
			throw new NoSuchKeyException();
		}
		if (product.getQuantity() < qty) {
			throw new NotEnoughQuantityException();
		}
		return product;
	}

	public void updateProductsQuantity(List<Product> products) {
		for (Product p : products) {
			Product product = warehouse.getProduct(p.getKey());
			product.setQuantity(product.getQuantity() - p.getQuantity());
			warehouse.update(product);
		}
	}

	// FOR REST

	public void insert(Product product) {
		warehouse.insert(product);
	}

	public void update(Product product) {
		warehouse.update(product);
	}

	public void delete(String key) {
		Product product = warehouse.getProduct(key);
		warehouse.delete(product);
	}
}
