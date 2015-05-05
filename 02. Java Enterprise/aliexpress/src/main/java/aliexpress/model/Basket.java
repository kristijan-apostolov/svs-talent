package aliexpress.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Basket {

	private ArrayList<Product> products = new ArrayList<Product>();

	public List<Product> getProducts() {
		return products;
	}

	public int getTotal() {
		int total = 0;
		for (Product p : products) {
			total += p.getPrice() * p.getQuantity();
		}
		return total;
	}

	public int getQuantity(String key) {
		for (Product p : products) {
			if (key.equals(p.getKey())) {
				return p.getQuantity();
			}
		}
		return 0;
	}

	public void add(Product product, int qty) {
		for (Product p : products) {
			if (p.getKey().equals(product.getKey())) {
				products.remove(p);
				break;
			}
		}
		products.add(new Product(product.getKey(), product.getName(), product
				.getPrice(), qty));
	}

}
