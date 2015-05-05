package aliexpress.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.controller.actions.Action;
import aliexpress.controller.actions.AddProductToBasketAction;
import aliexpress.controller.actions.CheckoutAction;
import aliexpress.controller.actions.ListProductsAction;
import aliexpress.controller.ui.UI;

@Component
public class ProductsMenu extends Menu {

	private ListProductsAction action1;
	private AddProductToBasketAction action2;
	private CheckoutAction action3;

	@Autowired
	public ProductsMenu(UI ui, ListProductsAction action1,
			AddProductToBasketAction action2, CheckoutAction action3) {
		super(ui);
		this.action1 = action1;
		this.action2 = action2;
		this.action3 = action3;
	}

	@Override
	public Action[] getActions() {
		Action[] actions = { action1, action2, action3 };
		return actions;
	}

}
