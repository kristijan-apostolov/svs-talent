public class NumberPrinterApplication {
	public static void main(String[] args) throws Exception {

		int number = Integer.parseInt(args[0]);
		int time = Integer.parseInt(args[1]);

		NumberPrinter numberPrinter = new NumberPrinter(number);
		Thread threadNumPrinter = new Thread(numberPrinter);

		threadNumPrinter.start();
		threadNumPrinter.join();
		threadNumPrinter.interrupt();

	}
}
