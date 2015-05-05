package dao.templates;

import org.hibernate.Session;

public interface HibernateGetSetter {

	<T> T returnQuery(Session session);
}
