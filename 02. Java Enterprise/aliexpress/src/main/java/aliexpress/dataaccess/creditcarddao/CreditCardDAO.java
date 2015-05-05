package aliexpress.dataaccess.creditcarddao;

import java.util.List;

import aliexpress.model.Account;
import aliexpress.model.CreditCard;

public interface CreditCardDAO {

	List<CreditCard> getAll(Account account);

	CreditCard get(long cardnumber);

	void insertOrUpdate(CreditCard creditcard);
}
