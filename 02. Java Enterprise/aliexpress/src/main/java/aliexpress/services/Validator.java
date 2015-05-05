package aliexpress.services;

import java.util.List;
import aliexpress.model.Account;
import aliexpress.services.exceptions.EmailExistsException;

public class Validator {

	public static void checkEmail(List<Account> list, Account account)
			throws EmailExistsException {
		for (Account x : list) {
			if (x.getEmail().equals(account.getEmail())
					&& x.getId() != account.getId()) {
				throw new EmailExistsException();
			}
		}
	}

	public static boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
}
