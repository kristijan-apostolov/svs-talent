import java.util.Map;
import java.util.Map.Entry;

public class InMemoryWarehouse implements Warehouse {

	Map<String, Product> products;
	DatabaseLoader dbLoader;

	public InMemoryWarehouse(Loader loader) {
		products = loader.load();
	}

	public InMemoryWarehouse(DatabaseLoader dbLoader) {
		products = dbLoader.load();
	}

	public String listAllProducts() {
		String s = "All products:\n";
		for (Entry<String, Product> entry : products.entrySet()) {
			Product product = entry.getValue();
			s += "Key:" + product.getKey() + " Name:" + product.getName()
					+ " Price:" + product.getPrice() + "\n";

		}
		return s;
	}

	public Map<String, Product> getProducts() {
		return products;
	}

}
