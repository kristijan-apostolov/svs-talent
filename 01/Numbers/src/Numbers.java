public class Numbers {

	public static void main(String[] args) {

		int number = 0;

		for (String s : args) {
			switch (s) {
			case "zero":
				number = number * 10 + 0;
				break;
			case "one":
				number = number * 10 + 1;
				break;
			case "two":
				number = number * 10 + 2;
				break;
			case "three":
				number = number * 10 + 3;
				break;
			case "four":
				number = number * 10 + 4;
				break;
			case "five":
				number = number * 10 + 5;
				break;
			case "six":
				number = number * 10 + 6;
				break;
			case "seven":
				number = number * 10 + 7;
				break;
			case "eight":
				number = number * 10 + 8;
				break;
			case "nine":
				number = number * 10 + 9;
				break;
			}

		}
		System.out.println(number);

	}

}
