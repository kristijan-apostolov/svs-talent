package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import dao.templates.HibernateCommitSetter;
import dao.templates.HibernateGetSetter;
import dao.templates.HibernateTemplate;
import entities.BaseEntity;
import entities.Publication;

public class HibernatePublicationDAO implements DAO {

	HibernateTemplate hibernateTemplate = new HibernateTemplate();

	@SuppressWarnings("unchecked")
	public List<Publication> getAll() {

		return hibernateTemplate.returnQuery(new HibernateGetSetter() {

			public List<Publication> returnQuery(Session session) {
				Query query = session.createQuery("FROM Publication");
				return query.list();
			}

		});
	}

	@SuppressWarnings("unchecked")
	public BaseEntity get(final long id) {

		return hibernateTemplate.returnQuery(new HibernateGetSetter() {

			public BaseEntity returnQuery(Session session) {
				Query query = session
						.createQuery("FROM Publication where id=:id");
				query.setParameter("id", id);
				return (BaseEntity) query.uniqueResult();
			}

		});
	}

	public void insert(final BaseEntity entity) {

		hibernateTemplate.makeTransaction(new HibernateCommitSetter() {

			public void makeTransaction(Session session) {
				session.save(entity);
			}

		});
	}

	public void update(final BaseEntity entity) {
		hibernateTemplate.makeTransaction(new HibernateCommitSetter() {

			public void makeTransaction(Session session) {
				session.update(entity);
			}

		});
	}

	public void delete(final BaseEntity entity) {
		hibernateTemplate.makeTransaction(new HibernateCommitSetter() {

			public void makeTransaction(Session session) {
				session.delete(entity);
			}

		});
	}

}
