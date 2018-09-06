package FileJava;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ClientClass {

	public static void main(String[] args) {
		// Hibernate Integrate With Spring
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("Resources/hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=meta.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		Employee e1=new Employee();
		e1.setId(12);
		e1.setFirstName("Suresh");
		e1.setLastName("Pandey");
		
		s.saveOrUpdate(e1);
		t.commit();
		
		
		sf.close();
		s.close();
		

	}

}
