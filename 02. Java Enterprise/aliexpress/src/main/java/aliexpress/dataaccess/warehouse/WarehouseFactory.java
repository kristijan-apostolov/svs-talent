package aliexpress.dataaccess.warehouse;

public class WarehouseFactory {

	public static Warehouse createWarehouse(int dao) {
		switch (dao) {
		case 2:
			return new JDBCWarehouse();
		case 3:
			return new HibernateWarehouse();
		default:
			return new InMemoryWarehouse();
		}
	}
}
