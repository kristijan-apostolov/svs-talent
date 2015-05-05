package aliexpress.controller.webapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aliexpress.model.Product;
import aliexpress.services.WarehouseService;

@RestController()
@RequestMapping("/api/warehouse")
public class WarehouseRestController {

	private WarehouseService warehouseService;

	@Autowired
	public WarehouseRestController(WarehouseService warehouseService) {
		super();
		this.warehouseService = warehouseService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> listProducts() {
		return warehouseService.getProducts();
	}

	@RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("key") String key) {
		warehouseService.delete(key);
		return "Success";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		warehouseService.insert(product);
		return product;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product,
			@PathVariable("key") Long id) {
		product.setId(id);
		warehouseService.update(product);
		return product;
	}
}
