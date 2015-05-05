package controller.actions;

import java.util.List;

import services.MemberService;
import services.exceptions.EmailExistsException;
import services.exceptions.GenericDBException;
import services.exceptions.InvalidEmailException;
import services.exceptions.NoSuchIdException;
import application.LibraryApp;
import entities.Member;

public class MemberController {

	private MemberService memberService = new MemberService();

	public void listOptions() {
		System.out.println("1. List members");
		System.out.println("2. Register member");
		System.out.println("3. Update member");
		System.out.println("4. Delete member");
		System.out.println("5. Exit");
	}

	public void listMembers() {
		try {
			List<Member> list = memberService.getMembers();
			for (Member p : list) {
				System.out.println(p);
			}
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		}
	}

	public void registerMember() {
		try {
			System.out.println("Enter name:");
			String name = LibraryApp.in.next();
			System.out.println("Enter e-mail:");
			String email = LibraryApp.in.next();
			memberService.registerMember(name, email);
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		} catch (EmailExistsException e) {
			LibraryApp.logger.log("E-mail already exists!");
		} catch (InvalidEmailException e) {
			LibraryApp.logger.log("Invalid e-mail!");
		}
	}

	public void updateMember() {
		try {
			System.out.println("Enter ID:");
			long id = Long.parseLong(LibraryApp.in.next());
			System.out.println("Enter new name:");
			String name = LibraryApp.in.next();
			System.out.println("Enter new email:");
			String email = LibraryApp.in.next();
			memberService.updateMember(id, name, email);

		} catch (NumberFormatException e) {
			LibraryApp.logger.log("Insert number for ID!");
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		} catch (EmailExistsException e) {
			LibraryApp.logger.log("E-mail already exists!");
		} catch (NoSuchIdException e) {
			LibraryApp.logger.log("No such member ID!");
		} catch (InvalidEmailException e) {
			LibraryApp.logger.log("Invalid e-mail!");
		}
	}

	public void deleteMember() {
		try {
			System.out.println("Enter ID:");
			long id = Long.parseLong(LibraryApp.in.next());
			memberService.deleteMember(id);
		} catch (NumberFormatException e) {
			LibraryApp.logger.log("Insert number for ID!");
		} catch (GenericDBException e) {
			LibraryApp.logger.log("We're sorry. An error has occured.");
		} catch (NoSuchIdException e) {
			LibraryApp.logger.log("No such member ID!");
		}
	}
}
