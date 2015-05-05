package aliexpress.dataaccess.connections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import aliexpress.model.Product;

public class ProductParser {

	public static ArrayList<Product> getProducts()
			throws NumberFormatException, IOException {

		ArrayList<Product> list = new ArrayList<Product>();

		FileReader file = new FileReader("src/main/resources/products.txt");
		BufferedReader buff = new BufferedReader(file);
		String line;

		while ((line = buff.readLine()) != null) {
			String[] w = line.split("\\|");
			list.add(new Product(w[0], w[1], Integer.parseInt(w[2]), Integer
					.parseInt(w[3])));
		}
		buff.close();
		file.close();

		return list;
	}

}
