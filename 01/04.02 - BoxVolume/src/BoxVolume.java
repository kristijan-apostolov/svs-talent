public class BoxVolume {

	private int height;
	private int weight;
	private int depth;

	public BoxVolume(int height, int weight, int depth) {

		this.height = height;
		this.weight = weight;
		this.depth = depth;
	}
	public int volume() {
		return this.depth * this.weight * this.height;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public int getDepth() {
		return depth;
	}
}
