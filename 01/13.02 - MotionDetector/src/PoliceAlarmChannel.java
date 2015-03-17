import motionDetector.AlarmChannel;

public class PoliceAlarmChannel implements AlarmChannel {

	@Override
	public void run() {
		System.out.println("The police is on it's way");

	}

}
