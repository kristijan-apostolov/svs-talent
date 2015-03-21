import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchApplication {

	private static final int NUMBER_OF_OPERATIONS = 10;

	public static void main(String[] args) throws Exception {

		ArrayList<Future<Integer>> rezults = new ArrayList<Future<Integer>>();
		Integer max = 0;

		final CountDownLatch latch = new CountDownLatch(NUMBER_OF_OPERATIONS);
		final ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 1; i <= NUMBER_OF_OPERATIONS; i++) {
			Future<Integer> complexCalculationFuture = executorService
					.submit(new ComplexOperation(i, latch));

			rezults.add(complexCalculationFuture);

		}

		System.out.println("Waithing for all complex operations to finish...");

		System.out.println("All complex operations finished.");

		for (Future<Integer> f : rezults) {
			if (max < f.get()) {
				max = f.get();
			}
		}
		System.out.println("Sum:"+ max);
		executorService.shutdown();

	}
}
