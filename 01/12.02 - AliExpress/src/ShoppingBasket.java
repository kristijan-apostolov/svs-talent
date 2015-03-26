import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingBasket implements Basket {

	private Map<String, Product> basket;
	private Warehouse wareHouse;

	public ShoppingBasket(Warehouse wareHouse) {
		super();
		this.basket = new HashMap();
		this.wareHouse = wareHouse;
	}

	@Override
	public boolean addProduct(String key, int quantity)
			throws ProductNotFoundException, NotEnoughtProductsException {

		Product p = new Product();
		p.setKey(key);

		if (wareHouse.getProducts().get(key) != null) {
			p.setName(wareHouse.getProducts().get(key).getName());
			p.setPrice(wareHouse.getProducts().get(key).getPrice() * quantity);
			p.setQuantity(quantity);
		} else {
			throw new ProductNotFoundException(
					"Product does not exit in warehouse");
		}

		if (wareHouse.getProducts().containsKey(p.getKey())) {
			if (basket.containsKey(p.getKey())) {
				if (quantity + basket.get(key).getQuantity() > wareHouse
						.getProducts().get(key).getQuantity()) {
					System.err
							.println("there is not enought quantity of this product!");
					return false;
				} else {
					Product p1 = basket.get(p.getKey());
					p1.setPrice(p1.getPrice() + (p.getPrice() * quantity));
					p1.setQuantity(p1.getQuantity() + p.getQuantity());
					return true;
				}
			} else {
				if (quantity <= wareHouse.getProducts().get(key).getQuantity()) {
					basket.put(p.getKey(), p);
					return true;
				} else {
					throw new NotEnoughtProductsException(
							"there is not enought quantity of this product!");
				}

			}

		} else {
			throw new ProductNotFoundException(
					"Product does not exit in warehouse");
		}

	}

	@Override
	public boolean removeProduct(String key) throws ProductNotFoundException {
		basket.remove(key);
		return false;
	}

	@Override
	public Collection getBasketDetails() {

		return basket.values();
	}

	@Override
	public double getBasketPrice() {
		double price = 0.0d;
		Iterator iterator = getBasketDetails().iterator();
		while (iterator.hasNext()) {
			price += ((Product) iterator.next()).getPrice();
		}
		return price;
	}
	@Override
	public void removeAll()
	{
		basket.clear();
	}

}
