import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileLoader implements Loader {

	private String path;
	HashMap<String, Product> products;
	private FileReader fr;
	private BufferedReader br;

	public FileLoader(String path) {
		this.path = path;
		products = new HashMap<>();
		try {
			fr = new FileReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
	}

	public HashMap<String, Product> load() {

		try {
			while (br.read() != -1) {

				String s = br.readLine();

				String[] words = s.split("\\|");

				if (products.containsKey(words[0])) {
					Product tempProduct = products.get(words[0]);
					int quantity = tempProduct.getQuantity()
							+ Integer.parseInt(words[3]);
					tempProduct.setQuantity(quantity);
					products.put(words[0], tempProduct);
				} else {
					products.put(
							words[0],
							new Product(words[0], words[1], Float
									.parseFloat(words[2]), Integer
									.parseInt(words[3])));
				}
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}
}
