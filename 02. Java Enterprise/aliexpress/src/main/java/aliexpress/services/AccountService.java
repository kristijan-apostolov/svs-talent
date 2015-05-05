package aliexpress.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aliexpress.services.exceptions.NoSuchAccountException;
import aliexpress.dataaccess.accountdao.AccountDAO;
import aliexpress.model.Account;
import aliexpress.services.exceptions.EmailExistsException;
import aliexpress.services.exceptions.InvalidEmailException;

@Service
public class AccountService {

	private AccountDAO accountDAO;

	@Autowired
	public AccountService(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	public void insertOrUpdate(Account account) throws InvalidEmailException,
			EmailExistsException {
		if (!Validator.isValidEmailAddress(account.getEmail())) {
			throw new InvalidEmailException();
		}
		Validator.checkEmail(accountDAO.getAll(), account);

		accountDAO.insertOrUpdate(account);
	}

	public Account getAccount(String email, String password)
			throws NoSuchAccountException {
		Account account = accountDAO.get(email, password);
		if (account == null) {
			throw new NoSuchAccountException();
		}
		return account;
	}

}
