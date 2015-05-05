package aliexpress.controller.ui;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import aliexpress.controller.ui.logging.ConsoleLogger;
import aliexpress.controller.ui.logging.Logger;

@Component
public class ConsoleUI implements UI {

	private Scanner scanner = new Scanner(System.in);
	private Logger logger = new ConsoleLogger();

	@Override
	public String requestInput(String string) {
		System.out.println("Enter " + string + ":");
		return scanner.next();
	}

	@Override
	public void print(String message) {
		System.out.println(message);
	}

	@Override
	public void log(String message) {
		logger.log(message);
	}

}
