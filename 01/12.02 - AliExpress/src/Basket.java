
import java.util.Collection;


public interface Basket{

	boolean addProduct(String key,int quantity) throws Exception;
	boolean removeProduct(String key) throws ProductNotFoundException;
	Collection<Product> getBasketDetails();
	double getBasketPrice();
	void removeAll();
}
