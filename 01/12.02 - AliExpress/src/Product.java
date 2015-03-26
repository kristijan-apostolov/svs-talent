public class Product {

	private String key;
	private String name;
	private double price;
	private int quantity;
	

	public Product(String key, String name, double price, int quantity) {
		super();
		this.key = key;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		String s = "";
		s += "Key:" + this.key + "  Name:" + this.name + "  Price:" + price
				+ "  Quantity:" + this.quantity;
		return s;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName(){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
