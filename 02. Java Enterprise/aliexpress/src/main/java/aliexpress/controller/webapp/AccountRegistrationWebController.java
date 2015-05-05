package aliexpress.controller.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import aliexpress.model.Account;
import aliexpress.services.AccountService;
import aliexpress.services.exceptions.EmailExistsException;
import aliexpress.services.exceptions.InvalidEmailException;

@Controller
@SessionAttributes("account")
@RequestMapping("/accountRegistration")
public class AccountRegistrationWebController {

	private AccountService accountService;

	@Autowired
	public AccountRegistrationWebController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts() {
		return "AccountRegistration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerAccount(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password, Model model) {

		try {
			Account account = new Account(name, email, password);
			accountService.insertOrUpdate(account);
			model.addAttribute("account", account);
			
			return "redirect:/creditcard";
		} catch (InvalidEmailException e) {
			model.addAttribute("message", "Invalid e-mail!");
		} catch (EmailExistsException e) {
			model.addAttribute("message", "E-mail already exists!");
		}

		return "AccountRegistration";
	}
}
