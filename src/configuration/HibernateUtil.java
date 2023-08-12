package configuration;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import model.Address;
import model.Patient;

public class HibernateUtil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Map<String, Object> settings = new HashMap<>();
			settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/onetone");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "root");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			settings.put(Environment.SHOW_SQL, "true");
			

			registry = new StandardServiceRegistryBuilder().applySettings(settings).build();

			MetadataSources metadataSources = new MetadataSources(registry).addAnnotatedClass(Patient.class).addAnnotatedClass(Address.class);

			Metadata metadata = metadataSources.getMetadataBuilder().build();

			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}
}
