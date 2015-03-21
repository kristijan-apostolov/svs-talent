public class Stopwatch implements Runnable {

	int state;
	int counter;

	public void runningPause() {

		if (state == 0) {
			state = 1;
			while (state == 0 || state == 1) {
				System.out.println(counter);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					pause();
				}
				counter++;
			}
		}
	}

	public void pause() {
		try {
			synchronized (this) {
				wait();
			}
		} catch (InterruptedException e) {
		}
	}

	public void run() {
		runningPause();
	}

}
