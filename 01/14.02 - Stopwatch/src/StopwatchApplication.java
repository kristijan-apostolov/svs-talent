	import java.util.Scanner;
	
	public class StopwatchApplication {
		public static void main(String[] args) {
	
			int number = 0;
			Scanner input = new Scanner(System.in);
	
			Stopwatch stopwatch = new Stopwatch();
			Thread stopwatchThread = new Thread(stopwatch);
	
			System.out.println("1: Start");
			System.out.println("2: Pause/countinue");
			System.out.println("3: Stop");
	
			while (number != 3) {
				number = input.nextInt();
	
				switch (number) {
				case 1:
					if (stopwatch.state == 0) {
						stopwatchThread.start();
					} else {
						synchronized (stopwatch) {
							stopwatch.notify();
						}
					}	
					break;
				case 2:
					stopwatchThread.interrupt();
					break;
				}
			}
			System.out.println("total time:" + stopwatch.counter);
			System.exit(1000);
	
		}
	}
