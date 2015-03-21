import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ComplexOperation implements Callable<Integer> {

	private Integer orderNumber;
	private CountDownLatch latch;

	public ComplexOperation(Integer orderNumber, CountDownLatch latch) {
		this.orderNumber = orderNumber;
		this.latch = latch;
	}

	@Override
	public Integer call() throws Exception {
		try {
			System.out.println("Complex operation " + orderNumber
					+ " started...");
			TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 1);
			System.out.println("Complex operation " + orderNumber
					+ " completed.");
			latch.countDown();

		} catch (InterruptedException e) {
		}
		return new Random().nextInt(10 + 1);
	}
}
