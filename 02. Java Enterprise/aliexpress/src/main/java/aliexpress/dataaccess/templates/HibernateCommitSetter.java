package aliexpress.dataaccess.templates;

import org.hibernate.Session;

public interface HibernateCommitSetter {

	public void makeTransaction(Session session);
}
