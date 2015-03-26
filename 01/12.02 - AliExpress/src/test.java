
import java.sql.*;
public class test {
	public static void main(String[] args) {
		DatabaseLoader d=new DatabaseLoader("jdbc:postgresql://localhost:5432/Products", "postgres", "admin");
		d.load();
	}

	
	
	
}
