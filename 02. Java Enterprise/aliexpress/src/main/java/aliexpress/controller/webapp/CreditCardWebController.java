package aliexpress.controller.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import aliexpress.model.Account;
import aliexpress.model.CreditCard;
import aliexpress.services.CreditCardService;

@Controller
@SessionAttributes("account")
@RequestMapping("/creditcard")
public class CreditCardWebController {

	private CreditCardService creditCardService;

	@Autowired
	public CreditCardWebController(CreditCardService creditCardService) {
		super();
		this.creditCardService = creditCardService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getCreditCardScreen() {
		return "CreditCard";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerAccount(@RequestParam("cardNumber") Long cardNumber,
			@RequestParam("nameOnCard") String nameOnCard,
			@RequestParam("expirationMonth") byte expirationMonth,
			@RequestParam("expirationYear") short expirationYear,
			@RequestParam("cvc") short cvc,
			@ModelAttribute("account") Account account) {
		CreditCard creditCard = new CreditCard(cardNumber, nameOnCard,
				expirationMonth, expirationYear, cvc, account);
		creditCardService.add(creditCard);
		return "CreditCard";
	}
}
