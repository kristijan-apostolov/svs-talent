public class ZipCode {

	private int number;

	public ZipCode(int number) {
		if (lenght(number) == 5 || lenght(number) == 9) {
			this.number = number;
		} else {
			System.err.println("number doesn't have 5 or 9 digits");
		}
	}

	public int lenght(int x) {
		int length = String.valueOf(x).length();
		return length;
	}
}