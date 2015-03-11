
import java.util.StringTokenizer;

public class DateParser {

	public static void parser(String Date) {
		StringTokenizer st1 = new StringTokenizer(Date, "/");
		String day;
		String month;
		String year;

		System.out.println(day = st1.nextToken());
		System.out.println(month = st1.nextToken());
		System.out.println(year = st1.nextToken());

	}

	public static void main(String[] args) {
		DateParser.parser("12/10/1989");
	}

}
