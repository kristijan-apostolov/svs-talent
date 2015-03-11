public class BoxVolume implements Comparable {

	private int height;
	private int weight;
	private int depth;

	public BoxVolume(int height, int weight, int depth) {
	
		this.height = height;
		this.weight = weight;
		this.depth = depth;
	}

	public int volume() {
		return this.depth * this.weight *this.height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int compareTo(Object boxVolume) {
		BoxVolume box = (BoxVolume) boxVolume;
		if (this.volume() > box.volume()) {
			return 1;
		} else if (this.volume() < box.volume()) {
			return -1;
		} else {
			return 0;
		}
	}

}