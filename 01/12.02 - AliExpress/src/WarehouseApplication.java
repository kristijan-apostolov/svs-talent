import java.util.Iterator;
import java.util.Scanner;

public class WarehouseApplication {

	public static void menu() {
		System.out.println("[1] List all products in the warehouse");
		System.out.println("[2] Add product to your shopping basket");
		System.out.println("[3] Remove product of your shopping basket");
		System.out.println("[4] List all products in the shopping basket");
		System.out.println("[5] Price of all products in Shopping basket");

		System.out.println("[6] Payment");
		System.out.println("[9] Exit");
	}

	public static void main(String[] args) {
		//config
		int flag = 1;// 0-> read from file 1 -> read from db

		Loader l = new FileLoader(
				"C:\\Users\\kiko\\Desktop\\AliExpress\\src\\tekst");
		DatabaseLoader d = new DatabaseLoader(
				"jdbc:postgresql://localhost:5432/Products", "postgres",
				"admin");
		InMemoryWarehouse w;
		
		if (flag == 0) {
			w = new InMemoryWarehouse(l);
		} else {
			w = new InMemoryWarehouse(d);
		}

		ShoppingBasket s = new ShoppingBasket(w);
		//end
		
		Scanner input = new Scanner(System.in);
		String key;
		int quantity;

		menu();
		int n = -1;
		while (n != 9) {

			n = input.nextInt();
			System.err.println("[0] Show menu");
			switch (n) {
			case 0:
				menu();
				break;
			case 1:
				System.out.println(w.listAllProducts());
				break;
			case 2:
				System.out.println("insert key and quantity");
				key = input.next();
				quantity = input.nextInt();
				try {
					s.addProduct(key, quantity);
				} catch (ProductNotFoundException | NotEnoughtProductsException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("insert key");
				String key1 = input.next();
				try {
					s.removeProduct(key1);
				} catch (ProductNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println();
				}
				break;
			case 4:
				System.out.println(s.getBasketDetails());
				break;
			case 5:
				System.out.println("sum of the price of the products:"
						+ s.getBasketPrice());
				break;
			case 6:
				Payment p = new ConsolePayment(w, s);
				p.pay();
				s.removeAll();
				break;
			}
		}
	}
}
