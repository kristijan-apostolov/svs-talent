package aliexpress.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Product extends BaseEntity {

	@Column(unique = true)
	private String key;
	private String name;
	private int price;
	private int quantity;

	public Product() {
		super();
	}

	public Product(String key, String name, int price, int quantity) {
		this.key = key;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return key + "|" + name + "|" + price;
	}

}
