package aliexpress.controller.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.controller.menu.ProductsMenu;

@Component
public class OpenShopAction implements Action {

	private ProductsMenu menu;

	@Autowired
	public OpenShopAction(ProductsMenu menu) {
		super();
		this.menu = menu;
	}

	@Override
	public String getTitle() {
		return "Shop";
	}

	@Override
	public void execute() {
		menu.run();
	}

}