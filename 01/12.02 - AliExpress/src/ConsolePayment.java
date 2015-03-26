import java.util.Iterator;

public class ConsolePayment implements Payment {

	private Warehouse w;
	private Basket b;

	public ConsolePayment(Warehouse w, Basket b) {
		this.w = w;
		this.b = b;
	}

	@Override
	public void pay() {

		Iterator iterator = b.getBasketDetails().iterator();
		while (iterator.hasNext()) {
			Product p1 = ((Product) iterator.next());
			Product p = w.getProducts().get(p1.getKey());
			System.out.println(p.toString());
			p.setQuantity(p.getQuantity() - p1.getQuantity());
			System.out.println(p.toString());

		}
	}

}
