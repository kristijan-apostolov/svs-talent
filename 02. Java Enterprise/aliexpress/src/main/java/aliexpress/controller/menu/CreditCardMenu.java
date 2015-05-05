package aliexpress.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.controller.actions.Action;
import aliexpress.controller.actions.AddCreditCardAction;
import aliexpress.controller.ui.UI;
import aliexpress.model.Account;

@Component
public class CreditCardMenu extends Menu {

	private AddCreditCardAction addCreditCardAction;

	@Autowired
	public CreditCardMenu(UI ui, AddCreditCardAction addCreditCardAction) {
		super(ui);
		this.addCreditCardAction = addCreditCardAction;
	}

	public void setAccount(Account account) {
		addCreditCardAction.setAccount(account);
	}

	@Override
	public Action[] getActions() {
		Action[] actions = { addCreditCardAction };
		return actions;
	}

}
