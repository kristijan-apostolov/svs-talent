package controller.actions;

import java.util.List;

import services.LoanService;
import services.exceptions.GenericDBException;
import services.exceptions.NoSuchIdException;
import application.LibraryApp;
import entities.Loan;

public class LoanController {

	private LoanService loanService = new LoanService();

	public void listOptions() {
		System.out.println("1. List loans");
		System.out.println("2. Add loan");
		System.out.println("3. Remove loan");
		System.out.println("4. Exit");
	}

	public void listLoans() {
		try {
			List<Loan> list = loanService.getLoans();
			for (Loan p : list) {
				System.out.println(p);
			}
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		}
	}

	public void addLoan() {
		try {
			System.out.println("Enter Member ID:");
			long memberId = Long.parseLong(LibraryApp.in.next());
			System.out.println("Enter Publication ID:");
			long publicationId = Long.parseLong(LibraryApp.in.next());
			loanService.addLoan(memberId, publicationId);
		} catch (NumberFormatException e) {
			LibraryApp.logger.log("Insert number for ID!");
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		} catch (NoSuchIdException e) {
			LibraryApp.logger.log("No such ID!");
		}
	}

	public void removeLoan() {
		try {
			System.out.println("Enter ID:");
			long id = Long.parseLong(LibraryApp.in.next());
			loanService.deleteLoan(id);
		} catch (NumberFormatException e) {
			LibraryApp.logger.log("Insert number for ID!");
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		} catch (NoSuchIdException e) {
			LibraryApp.logger.log("No such loan ID!");
		}
	}
}
