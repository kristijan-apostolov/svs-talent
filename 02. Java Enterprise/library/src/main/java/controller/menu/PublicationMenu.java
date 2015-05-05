package controller.menu;

import controller.actions.PublicationController;
import application.LibraryApp;

public class PublicationMenu implements Menu {

	private PublicationController publicationController = new PublicationController();

	public void run() {
		boolean end = false;
		while (!end) {
			publicationController.listOptions();

			int i = 0;
			try {
				i = Integer.parseInt(LibraryApp.in.next());
			} catch (NumberFormatException e) {
				LibraryApp.logger.log("Insert number!");
			}

			switch (i) {
			case 1:
				publicationController.listPublications();
				break;
			case 2:
				publicationController.registerBook();
				break;
			case 3:
				publicationController.registerMagazine();
				break;
			case 4:
				publicationController.updateBook();
				break;
			case 5:
				publicationController.updateMagazine();
				break;
			case 6:
				publicationController.unregisterPublication();
				break;
			case 7:
				end = true;
				break;
			}
		}
	}

}
