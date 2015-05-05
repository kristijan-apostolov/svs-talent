package aliexpress.controller.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import aliexpress.controller.ui.UI;
import aliexpress.model.Account;
import aliexpress.model.CreditCard;
import aliexpress.services.CreditCardService;

@Component
public class AddCreditCardAction implements Action {

	private Account account;

	private UI ui;
	private CreditCardService creditCardService;

	@Autowired
	public AddCreditCardAction(UI ui, CreditCardService creditCardService) {
		super();
		this.ui = ui;
		this.creditCardService = creditCardService;
	}

	@Override
	public String getTitle() {
		return "Add new credit card";
	}

	@Override
	public void execute() {
		long cardNumber = Long.parseLong(ui.requestInput("card number"));
		String nameOnCard = ui.requestInput("name on card");
		byte expirationMonth = Byte.parseByte(ui
				.requestInput("expiration month"));
		short expirationYear = Short.parseShort(ui
				.requestInput("expiration year"));
		short cvc = Short.parseShort(ui.requestInput("CVC2/CVV2"));
		CreditCard creditCard = new CreditCard(cardNumber, nameOnCard,
				expirationMonth, expirationYear, cvc, account);
		creditCardService.add(creditCard);
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
