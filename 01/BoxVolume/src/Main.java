public class BoxVolumeApplication {

	public static void main(String[] args) {

		BoxVolume box1 = new BoxVolume(2, 4, 3);
		BoxVolume box2 = new BoxVolume(8, 4, 3);

		if (box1.volume() > box2.volume()) {
			System.out.println("Height:" + box1.getHeight() + "\nWeight:"
					+ box1.getWeight() + "\nDepth:" + box1.getDepth());
		} else {
			System.out.println("Height:" + box2.getHeight() + "\nWeight:"
					+ box2.getWeight() + "\nDepth:" + box2.getDepth());
		}
	}
}

