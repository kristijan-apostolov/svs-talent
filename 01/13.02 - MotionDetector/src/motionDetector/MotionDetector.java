package motionDetector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MotionDetector {

	private ImageCapturingDevice device;
	private AlarmChannel alarm;

	public MotionDetector(ImageCapturingDevice device, AlarmChannel alarm) {
		this.device = device;
		this.alarm = alarm;
	}

	public void run() {
		List<byte[]> images = new ArrayList<byte[]>();
		int count = 0;
		try {
			while (true) {

				byte[] singleImage = device.getImage();
				images.add(count, singleImage);

				if (count > 0) {
					if (Arrays.equals(images.get(count), images.get(count - 1))) {

					} else {
						alarm.run();
					}
				}
				count++;
			}
		} catch (java.util.NoSuchElementException e) {
			System.out.println("Done");
		}

	}

	public void alarm() {
		alarm.run();
	}

}
