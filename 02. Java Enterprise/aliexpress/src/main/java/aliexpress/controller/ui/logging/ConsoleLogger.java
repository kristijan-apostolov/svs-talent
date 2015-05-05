package aliexpress.controller.ui.logging;

import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.println(message);
	}
}
