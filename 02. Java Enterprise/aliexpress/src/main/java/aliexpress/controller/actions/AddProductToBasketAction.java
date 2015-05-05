package aliexpress.controller.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.controller.ui.UI;
import aliexpress.model.Basket;
import aliexpress.model.Product;
import aliexpress.services.WarehouseService;
import aliexpress.services.exceptions.NoSuchKeyException;
import aliexpress.services.exceptions.NotEnoughQuantityException;

@Component
public class AddProductToBasketAction implements Action {

	private WarehouseService warehouseService;
	private UI ui;
	private Basket basket;

	@Autowired
	public AddProductToBasketAction(WarehouseService warehouseService, UI ui,
			Basket basket) {
		super();
		this.warehouseService = warehouseService;
		this.ui = ui;
		this.basket = basket;
	}

	@Override
	public String getTitle() {
		return "Add product to basket";
	}

	@Override
	public void execute() {
		try {
			String key = ui.requestInput("product key");
			int quantity = basket.getQuantity(key);
			quantity += Integer.parseInt(ui.requestInput("quantity"));
			Product p = warehouseService.getProduct(key, quantity);
			basket.add(p, quantity);
		} catch (NoSuchKeyException e) {
			ui.log("No such product key!");
		} catch (NotEnoughQuantityException e) {
			ui.log("We're sorry. There's not enough stock in the warehouse.");
		}
	}

}
