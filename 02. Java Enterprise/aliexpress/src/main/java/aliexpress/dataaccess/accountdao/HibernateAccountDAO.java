package aliexpress.dataaccess.accountdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aliexpress.dataaccess.templates.HibernateCommitSetter;
import aliexpress.dataaccess.templates.HibernateGetSetter;
import aliexpress.dataaccess.templates.HibernateTemplate;
import aliexpress.model.Account;

@Repository
public class HibernateAccountDAO implements AccountDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public HibernateAccountDAO(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Account> getAll() {

		return hibernateTemplate.returnQuery(new HibernateGetSetter() {

			@Override
			public List<Account> returnQuery(Session session) {
				Query query = session.createQuery("FROM Account");
				return query.list();
			}

		});
	}

	@Override
	public Account get(final String email, final String password) {
		return hibernateTemplate.returnQuery(new HibernateGetSetter() {

			@Override
			@SuppressWarnings("unchecked")
			public Account returnQuery(Session session) {
				Query query = session
						.createQuery("FROM Account where email=:email and password=:password");
				query.setParameter("email", email);
				query.setParameter("password", password);
				return (Account) query.uniqueResult();
			}

		});
	}

	@Override
	public void insertOrUpdate(final Account account) {
		hibernateTemplate.makeTransaction(new HibernateCommitSetter() {

			@Override
			public void makeTransaction(Session session) {
				session.saveOrUpdate(account);
			}

		});
	}

}
