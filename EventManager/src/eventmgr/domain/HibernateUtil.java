package eventmgr.domain;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static SessionFactory getSessionFactory()
	{
		Configuration config = new Configuration();
		SessionFactory sessionFactory =
				config.configure().buildSessionFactory( );
		
		return sessionFactory;

	}

}
