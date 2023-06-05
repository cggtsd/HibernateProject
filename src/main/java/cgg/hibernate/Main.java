package cgg.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//create student objects...
		
		
		Student s1 = new Student();
		s1.setId(102);
		s1.setName("XYZ");
		s1.setCity("Hyd");
		
		Certificate certi = new Certificate();
		certi.setCourse("Spring framework");
		certi.setDuration("2 months");
		
		s1.setCerti(certi);
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(s1);
		
		tx.commit();
		
		session.close();
		
		factory.close();
		
		

	}

}
