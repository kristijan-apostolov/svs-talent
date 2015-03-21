import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import org.apache.commons.lang3.StringUtils;

public class WordCounterApplication {

	public static void main(String[] args) throws IOException {
		StringUtils su = new StringUtils();
		su.equalsIgnoreCase("krisitjan", "Kristijan");
		
		Hashtable<String, Integer> ht = new Hashtable();

		FileReader fr = new FileReader(
				"C:\\Users\\kiko\\workspace\\helloWorldMaven\\src\\main\\resources\\text");
		BufferedReader br = new BufferedReader(fr);

		while (br.read() != -1) {

			String s = br.readLine();
			s = s.toUpperCase();
			String[] words = s.split(" ");

			for (int i = 0; i < words.length; i++) {

				if (ht.containsKey(words[i])) {
					int pom = ht.get(words[i]);

					ht.put(words[i], ++pom);
				} else {
					ht.put(words[i], 1);
				}

			}

		}
		System.out.println(ht.toString());
	}
}