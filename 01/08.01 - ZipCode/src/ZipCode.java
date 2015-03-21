public class ZipCode {

	private int number;

	public ZipCode(int number) {
		setNumber(number);
	}

	public void setNumber(int number) {
		if ((number > 9999 && number < 100000)
				|| (number > 99999999 && number < 1000000000))
			this.number = number;
		else
			System.err.println("zip code is not valid, 5 or 9 digits!");
	}
}
