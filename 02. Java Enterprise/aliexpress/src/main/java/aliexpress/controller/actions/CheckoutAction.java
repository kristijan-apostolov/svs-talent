package aliexpress.controller.actions;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import aliexpress.controller.ui.UI;
import aliexpress.model.Account;
import aliexpress.model.Basket;
import aliexpress.model.Product;
import aliexpress.services.AccountService;
import aliexpress.services.CreditCardService;
import aliexpress.services.WarehouseService;
import aliexpress.services.exceptions.NoCreditCardsException;
import aliexpress.services.exceptions.NoSuchAccountException;

@Component
public class CheckoutAction implements Action {

	private UI ui;
	private Basket basket;
	private AccountService accountService;
	private WarehouseService warehouseService;
	private CreditCardService creditCardService;

	@Autowired
	public CheckoutAction(UI ui, Basket basket, AccountService accountService,
			WarehouseService warehouseService,
			CreditCardService creditCardService) {
		super();
		this.ui = ui;
		this.basket = basket;
		this.accountService = accountService;
		this.warehouseService = warehouseService;
		this.creditCardService = creditCardService;
	}

	@Override
	public String getTitle() {
		return "Checkout";
	}

	@Override
	public void execute() {
		try {
			String email = ui.requestInput("e-mail");
			String password = ui.requestInput("password");
			Account account = accountService.getAccount(email, password);
			creditCardService.getCreditCards(account);

			List<Product> products = basket.getProducts();
			for (Product p : products) {
				ui.print(p.toString() + " | " + p.getQuantity());
			}
			ui.print("Total: " + basket.getTotal());

			warehouseService.updateProductsQuantity(products);

		} catch (NoSuchAccountException e) {
			ui.log("No such account!");
		} catch (NoCreditCardsException e) {
			ui.log("You haven't entered any credit cards!");
		}
	}

}
