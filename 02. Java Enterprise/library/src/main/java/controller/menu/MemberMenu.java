package controller.menu;

import application.LibraryApp;
import controller.actions.MemberController;

public class MemberMenu implements Menu {

	private MemberController memberController = new MemberController();

	public void run() {
		boolean end = false;
		while (!end) {
			memberController.listOptions();

			int i = 0;
			try {
				i = Integer.parseInt(LibraryApp.in.next());
			} catch (NumberFormatException e) {
				LibraryApp.logger.log("Insert number!");
			}

			switch (i) {
			case 1:
				memberController.listMembers();
				break;
			case 2:
				memberController.registerMember();
				break;
			case 3:
				memberController.updateMember();
				break;
			case 4:
				memberController.deleteMember();
				break;
			case 5:
				end = true;
				break;
			}
		}
	}

}
