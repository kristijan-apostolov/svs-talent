package aliexpress.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import aliexpress.controller.actions.AccountRegistrationAction;
import aliexpress.controller.actions.AccountUpdateAction;
import aliexpress.controller.actions.Action;
import aliexpress.controller.actions.OpenShopAction;
import aliexpress.controller.ui.UI;

@Component
public class MainMenu extends Menu {

	private AccountRegistrationAction action1;
	private AccountUpdateAction action2;
	private OpenShopAction action3;

	@Autowired
	public MainMenu(UI ui, AccountRegistrationAction action1,
			AccountUpdateAction action2, OpenShopAction action3) {
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
