package aliexpress.controller.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import aliexpress.controller.ui.UI;
import aliexpress.model.Product;
import aliexpress.services.WarehouseService;

@Component
public class ListProductsAction implements Action {

	private WarehouseService warehouseService;
	private UI ui;

	@Autowired
	public ListProductsAction(WarehouseService warehouseService, UI ui) {
		super();
		this.warehouseService = warehouseService;
		this.ui = ui;
	}

	@Override
	public String getTitle() {
		return "List Products";
	}

	@Override
	public void execute() {
		List<Product> products = warehouseService.getProducts();
		for (Product product : products) {
			ui.print(product.toString());
		}
	}

}
