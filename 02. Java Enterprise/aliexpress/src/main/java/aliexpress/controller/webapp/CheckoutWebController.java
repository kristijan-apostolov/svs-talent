package aliexpress.controller.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import aliexpress.model.Account;
import aliexpress.model.Basket;
import aliexpress.services.AccountService;
import aliexpress.services.CreditCardService;
import aliexpress.services.WarehouseService;
import aliexpress.services.exceptions.NoCreditCardsException;
import aliexpress.services.exceptions.NoSuchAccountException;

@Controller
@SessionAttributes("basket")
@RequestMapping("/checkout")
public class CheckoutWebController {

	private AccountService accountService;
	private WarehouseService warehouseService;
	private CreditCardService creditCardService;

	@Autowired
	public CheckoutWebController(AccountService accountService,
			WarehouseService warehouseService,
			CreditCardService creditCardService) {
		super();
		this.accountService = accountService;
		this.warehouseService = warehouseService;
		this.creditCardService = creditCardService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String listProducts(Model model,
			@ModelAttribute("basket") Basket basket,
			@RequestParam("email") String email,
			@RequestParam("password") String password) {

		try {
			Account account = accountService.getAccount(email, password);
			creditCardService.getCreditCards(account);

			model.addAttribute("products", basket.getProducts());
			model.addAttribute("total", basket.getTotal());

			warehouseService.updateProductsQuantity(basket.getProducts());

			model.addAttribute("message", "Success!");

		} catch (NoSuchAccountException e) {
			model.addAttribute("message", "No such account!");
		} catch (NoCreditCardsException e) {
			model.addAttribute("message",
					"You haven't entered any credit cards!");
		}

		return "Checkout";
	}
}
