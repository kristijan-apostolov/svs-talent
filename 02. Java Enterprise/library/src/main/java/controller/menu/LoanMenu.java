package controller.menu;

import application.LibraryApp;
import controller.actions.LoanController;

public class LoanMenu implements Menu {

	private LoanController loanController = new LoanController();

	public void run() {
		boolean end = false;
		while (!end) {
			loanController.listOptions();

			int i = 0;
			try {
				i = Integer.parseInt(LibraryApp.in.next());
			} catch (NumberFormatException e) {
				LibraryApp.logger.log("Insert number!");
			}

			switch (i) {
			case 1:
				loanController.listLoans();
				break;
			case 2:
				loanController.addLoan();
				break;
			case 3:
				loanController.removeLoan();
				break;
			case 4:
				end = true;
				break;
			}
		}
	}

}
