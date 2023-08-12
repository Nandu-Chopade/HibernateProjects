package code.configuration;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import code.model.Answers;
import code.model.Questions;

public class HibernateUtil {
public static StandardServiceRegistry  registry;
	
	public static SessionFactory sf;
	
	public static SessionFactory getFactory()
	{
		
		if(sf==null)
		{
			Map<String,Object>m=new HashMap<>();
			m.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			m.put(Environment.URL, "jdbc:mysql://localhost:3306/manytomany");
			m.put(Environment.USER, "root");
			m.put(Environment.PASS, "root");
			m.put(Environment.HBM2DDL_AUTO, "create");
			m.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			m.put(Environment.SHOW_SQL, "true");
			
			registry=new StandardServiceRegistryBuilder().applySettings(m).build();
			
			MetadataSources mdata=new MetadataSources(registry).addAnnotatedClass(Questions.class).addAnnotatedClass(Answers.class);
			Metadata md=mdata.getMetadataBuilder().build();
			
			sf=md.getSessionFactoryBuilder().build();
			
		}
		return sf;
	}

}