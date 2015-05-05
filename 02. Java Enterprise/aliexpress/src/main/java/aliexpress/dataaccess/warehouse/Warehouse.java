package aliexpress.dataaccess.warehouse;

import java.util.List;
import aliexpress.model.Product;

public interface Warehouse {

	List<Product> getProducts();

	Product getProduct(String key);

	void update(Product product);

	void insert(Product product);

	void delete(Product product);
}
