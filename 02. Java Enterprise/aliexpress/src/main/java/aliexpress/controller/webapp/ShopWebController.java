package aliexpress.controller.webapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aliexpress.model.Basket;
import aliexpress.model.Product;
import aliexpress.services.WarehouseService;
import aliexpress.services.exceptions.NoSuchKeyException;
import aliexpress.services.exceptions.NotEnoughQuantityException;

@Controller
@SessionAttributes("basket")
@RequestMapping("/shop")
public class ShopWebController {

	private WarehouseService warehouseService;

	@Autowired
	public ShopWebController(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	@ModelAttribute("products")
	public List<Product> getProducts() {
		return warehouseService.getProducts();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts(Model model) {
		if (!model.containsAttribute("basket")) {
			model.addAttribute("basket", new Basket());
		}
		return "Shop";
	}

	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	public String addToBasket(@PathVariable("key") String key,
			@ModelAttribute("basket") Basket basket, Model model)
			throws NoSuchKeyException {
		try {
			int quantity = 1 + basket.getQuantity(key);
			Product product = warehouseService.getProduct(key, quantity);
			basket.add(product, quantity);
		} catch (NotEnoughQuantityException e) {
		}
		return "redirect:/shop";
	}

}
