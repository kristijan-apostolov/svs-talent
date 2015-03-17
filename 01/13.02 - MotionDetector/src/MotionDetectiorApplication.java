import motionDetector.AlarmChannel;
import motionDetector.ImageCapturingDevice;
import motionDetector.MotionDetector;

public class MotionDetectiorApplication {
	public static void main(String[] args) {

		ImageCapturingDevice camera = new Camera();

		AlarmChannel alarm = new PoliceAlarmChannel();

		MotionDetector detector = new MotionDetector(camera, alarm);

		detector.run();

	}

}
