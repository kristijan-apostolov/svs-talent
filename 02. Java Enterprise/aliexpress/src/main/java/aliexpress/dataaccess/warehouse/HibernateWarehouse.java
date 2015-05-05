package aliexpress.dataaccess.warehouse;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import aliexpress.dataaccess.templates.HibernateCommitSetter;
import aliexpress.dataaccess.templates.HibernateGetSetter;
import aliexpress.dataaccess.templates.HibernateTemplate;
import aliexpress.model.Product;

@SuppressWarnings("unchecked")
@Repository
public class HibernateWarehouse implements Warehouse {

	private HibernateTemplate hibernateTemplate;

	public HibernateWarehouse() {

	}

	@Autowired
	public HibernateWarehouse(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Product> getProducts() {

		return hibernateTemplate.returnQuery(new HibernateGetSetter() {

			@Override
			public List<Product> returnQuery(Session session) {
				List<Product> results = session.createQuery("FROM Product")
						.list();
				return results;
			}

		});

	}

	@Override
	public Product getProduct(final String key) {

		return hibernateTemplate.returnQuery(new HibernateGetSetter() {

			@Override
			public Product returnQuery(Session session) {
				Query query = session
						.createQuery("FROM Product WHERE key=:key");
				query.setParameter("key", key);
				return (Product) query.uniqueResult();
			}

		});

	}

	@Override
	public void update(final Product product) {
		hibernateTemplate.makeTransaction(new HibernateCommitSetter() {

			@Override
			public void makeTransaction(Session session) {
				session.update(product);
			}

		});
	}

	@Override
	public void insert(final Product product) {

		hibernateTemplate.makeTransaction(new HibernateCommitSetter() {

			@Override
			public void makeTransaction(Session session) {
				session.save(product);
			}

		});
	}

	@Override
	public void delete(final Product product) {
		hibernateTemplate.makeTransaction(new HibernateCommitSetter() {

			@Override
			public void makeTransaction(Session session) {
				session.delete(product);
			}

		});
	}

}
