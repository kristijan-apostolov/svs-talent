package aliexpress.dataaccess.creditcarddao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aliexpress.dataaccess.templates.HibernateCommitSetter;
import aliexpress.dataaccess.templates.HibernateGetSetter;
import aliexpress.dataaccess.templates.HibernateTemplate;
import aliexpress.model.Account;
import aliexpress.model.CreditCard;

@SuppressWarnings("unchecked")
@Repository
public class HibernateCreditCardDAO implements CreditCardDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public HibernateCreditCardDAO(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<CreditCard> getAll(final Account account) {
		return hibernateTemplate.returnQuery(new HibernateGetSetter() {

			@Override
			public List<CreditCard> returnQuery(Session session) {
				Query query = session
						.createQuery("FROM CreditCard WHERE account=:account");
				query.setParameter("account", account);
				return query.list();
			}

		});
	}

	@Override
	public CreditCard get(final long cardnumber) {
		return hibernateTemplate.returnQuery(new HibernateGetSetter() {

			@Override
			public CreditCard returnQuery(Session session) {
				Query query = session
						.createQuery("FROM CreditCard where cardnumber=:cardnumber");
				query.setParameter("cardnumber", cardnumber);
				return (CreditCard) query.uniqueResult();
			}

		});
	}

	@Override
	public void insertOrUpdate(final CreditCard creditcard) {
		hibernateTemplate.makeTransaction(new HibernateCommitSetter() {

			@Override
			public void makeTransaction(Session session) {
				session.saveOrUpdate(creditcard);
			}

		});
	}

}
