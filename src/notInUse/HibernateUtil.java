package notInUse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory provideSessionFactory() {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		return config.buildSessionFactory();
	}
}
