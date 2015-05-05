package aliexpress.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aliexpress.dataaccess.creditcarddao.CreditCardDAO;
import aliexpress.model.Account;
import aliexpress.model.CreditCard;
import aliexpress.services.exceptions.NoCreditCardsException;

@Service
public class CreditCardService {

	private CreditCardDAO creditcardDAO;

	@Autowired
	public CreditCardService(CreditCardDAO creditcardDAO) {
		super();
		this.creditcardDAO = creditcardDAO;
	}

	public List<CreditCard> getCreditCards(Account account)
			throws NoCreditCardsException {
		List<CreditCard> creditcards = creditcardDAO.getAll(account);
		if (creditcards.isEmpty()) {
			throw new NoCreditCardsException();
		}
		return creditcards;
	}

	public void add(CreditCard creditcard) {
		creditcardDAO.insertOrUpdate(creditcard);
	}
}
