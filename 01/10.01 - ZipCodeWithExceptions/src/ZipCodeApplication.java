public class ZipCodeApplication {

	public static void main(String[] args) {

		try {
			ZipCode zipcode1 = new ZipCode(55555);
		} catch (InvalidArgumentException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {
			ZipCode zipcode1 = new ZipCode(4444);
		} catch (InvalidArgumentException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
}