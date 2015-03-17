import java.util.Scanner;

import motionDetector.ImageCapturingDevice;

public class Camera implements ImageCapturingDevice {

	@Override
	public byte[] getImage() {
		System.out.println("insert string/ will be converted in image");
		Scanner input = new Scanner(System.in);
		String image = input.next();
		byte b[] = image.getBytes();
		return b;
	}
}
