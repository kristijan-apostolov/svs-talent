package aliexpress.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import aliexpress.controller.menu.MainMenu;
import aliexpress.dataaccess.connections.HibernateConnection;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "aliexpress")
public class AliExpressApplication implements CommandLineRunner {

	@Autowired
	private MainMenu menu;

	public static void main(String[] args) {
		SpringApplication.run(AliExpressApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		HibernateConnection.createSessionFactory();
		menu.run();
		HibernateConnection.closeSessionFactory();
	}
}
