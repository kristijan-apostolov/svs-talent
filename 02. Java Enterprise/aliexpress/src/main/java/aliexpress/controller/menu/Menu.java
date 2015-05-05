package aliexpress.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.controller.actions.Action;
import aliexpress.controller.ui.UI;
import aliexpress.services.exceptions.GenericDBException;

@Component
public abstract class Menu {

	private UI ui;

	@Autowired
	public Menu(UI ui) {
		this.ui = ui;
	}

	public abstract Action[] getActions();

	public void run() {
		while (true) {
			Action[] actions = getActions();

			for (int i = 0; i < actions.length; i++) {
				ui.print((i + 1) + ". " + actions[i].getTitle());
			}
			ui.print("0. Return");

			try {
				int choice = Integer.parseInt(ui.requestInput("command"));
				if (choice == 0) {
					break;
				}
				actions[choice - 1].execute();
			} catch (NumberFormatException e) {
				ui.log("Invalid input!");
			} catch (ArrayIndexOutOfBoundsException e) {
				ui.log("Invalid input!");
			} catch (GenericDBException e) {
				ui.log("We're sorry. An error has occured.");
			}
		}
	}
}
