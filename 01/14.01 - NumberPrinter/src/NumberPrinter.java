public class NumberPrinter implements Runnable {

	private int number;

	public NumberPrinter(int number) {
		this.number = number;
	}

	public void run() {
		for (int i = 0; i < this.number; i++) {

			System.out.println(i);
			if (Thread.interrupted()) {
				System.out.println("...been interrupted");
				return;
			}

		}

	}

}
