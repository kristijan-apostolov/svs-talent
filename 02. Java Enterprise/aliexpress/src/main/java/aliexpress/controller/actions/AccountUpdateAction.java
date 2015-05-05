package aliexpress.controller.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import aliexpress.controller.menu.CreditCardMenu;
import aliexpress.controller.ui.UI;
import aliexpress.model.Account;
import aliexpress.services.AccountService;
import aliexpress.services.exceptions.EmailExistsException;
import aliexpress.services.exceptions.InvalidEmailException;
import aliexpress.services.exceptions.NoSuchAccountException;

@Component
public class AccountUpdateAction implements Action {

	private UI ui;
	private AccountService accountService;
	private CreditCardMenu creditCardMenu;

	@Autowired
	public AccountUpdateAction(UI ui, AccountService accountService,
			CreditCardMenu creditCardMenu) {
		super();
		this.ui = ui;
		this.accountService = accountService;
		this.creditCardMenu = creditCardMenu;
	}

	@Override
	public String getTitle() {
		return "Modify Account";
	}

	@Override
	public void execute() {
		try {
			String oldEmail = ui.requestInput("e-mail");
			String oldPassword = ui.requestInput("password");
			Account account = accountService.getAccount(oldEmail, oldPassword);

			account.setName(ui.requestInput("new name"));
			account.setEmail(ui.requestInput("new e-mail"));
			account.setPassword(ui.requestInput("new password"));

			accountService.insertOrUpdate(account);

			creditCardMenu.setAccount(account);
			creditCardMenu.run();
		} catch (NoSuchAccountException e) {
			ui.log("No such account!");
		} catch (InvalidEmailException e) {
			ui.log("Invalid e-mail!");
		} catch (EmailExistsException e) {
			ui.log("E-mail already exists!");
		}
	}

}
