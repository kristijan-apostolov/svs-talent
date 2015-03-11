public class Main {

	public static void main(String[] args) {

		BoxVolume box1 = new BoxVolume(2, 4, 3);
		BoxVolume box2 = new BoxVolume(1, 4, 3);
		
		if (box1.compareTo(box2) == 1)
		{
			System.out.println("first box's volume is greater than second one");
			System.out.println("height:" + box1.getHeight());
			System.out.println("weight:" + box1.getWeight());
			System.out.println("depth:" + box1.getDepth());
		}
		else if (box1.compareTo(box2) == -1)
		{
			System.out.println("second box's volume is greater than first one");
			System.out.println("height:" + box2.getHeight());
			System.out.println("weight:" + box2.getWeight());
			System.out.println("depth:" + box2.getDepth());
		}
		else
		{
			System.out.println("Their volumes are equal");
		}

	}

}
