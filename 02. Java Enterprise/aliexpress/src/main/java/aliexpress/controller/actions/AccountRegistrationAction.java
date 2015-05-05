package aliexpress.controller.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import aliexpress.controller.menu.CreditCardMenu;
import aliexpress.controller.ui.UI;
import aliexpress.model.Account;
import aliexpress.services.AccountService;
import aliexpress.services.exceptions.EmailExistsException;
import aliexpress.services.exceptions.InvalidEmailException;

@Component
public class AccountRegistrationAction implements Action {

	private UI ui;
	private AccountService accountService;
	private CreditCardMenu creditCardMenu;

	@Autowired
	public AccountRegistrationAction(UI ui, AccountService accountService,
			CreditCardMenu creditCardMenu) {
		super();
		this.ui = ui;
		this.accountService = accountService;
		this.creditCardMenu = creditCardMenu;
	}

	@Override
	public String getTitle() {
		return "Account Registration";
	}

	@Override
	public void execute() {
		try {
			String name = ui.requestInput("name");
			String email = ui.requestInput("e-mail");
			String password = ui.requestInput("password");
			Account account = new Account(name, email, password);
			accountService.insertOrUpdate(account);

			creditCardMenu.setAccount(account);
			creditCardMenu.run();
		} catch (InvalidEmailException e) {
			ui.log("Invalid e-mail!");
		} catch (EmailExistsException e) {
			ui.log("E-mail already exists!");
		}
	}
}
