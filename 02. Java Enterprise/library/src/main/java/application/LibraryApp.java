package application;

import java.util.Scanner;

import controller.menu.MainMenu;
import controller.menu.Menu;
import dao.connections.HibernateConnection;
import logging.ConsoleLogger;
import logging.Logger;

public class LibraryApp {

	public static Scanner in = new Scanner(System.in);
	public static Logger logger = new ConsoleLogger();

	public static void main(String[] args) {
		HibernateConnection.createSessionFactory();

		Menu menu = new MainMenu();
		menu.run();

		in.close();
		HibernateConnection.closeSessionFactory();
	}
}
