package cgg.hibernate.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cgg.hibernate.Certificate;
import cgg.hibernate.Student;

public class StateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		
		Session s = factory.openSession();
		
		//Transaction tx = s.beginTransaction();
		
		Student student = s.get(Student.class, 102);
		
		//detached state
		//s.evict(student);
		
		//student.setName("ZZZ");
		
		//s.update(student);
		//removed state
		
		//s.delete(student);
		
		//s.update(student);
		
		//tx.commit();
		s.close();
		
		student.setName("AAA");
		s=factory.openSession();
		
		Transaction t=s.beginTransaction();
		
		s.update(student);		
				
		t.commit();
				
		s.close();
		factory.close();

	}

}
