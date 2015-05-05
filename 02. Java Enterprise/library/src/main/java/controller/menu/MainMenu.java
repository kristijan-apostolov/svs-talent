package controller.menu;

import application.LibraryApp;

public class MainMenu implements Menu {

	public void listOptions() {
		System.out.println("1. Manage publications");
		System.out.println("2. Member registration");
		System.out.println("3. Lend publications");
		System.out.println("4. Exit");
	}

	public void run() {
		boolean end = false;
		while (!end) {
			listOptions();

			int i = 0;
			try {
				i = Integer.parseInt(LibraryApp.in.next());
			} catch (NumberFormatException e) {
				LibraryApp.logger.log("Insert number!");
			}

			switch (i) {
			case 1:
				new PublicationMenu().run();
				break;
			case 2:
				new MemberMenu().run();
				break;
			case 3:
				new LoanMenu().run();
				break;
			case 4:
				end = true;
				break;
			}
		}
	}

}
