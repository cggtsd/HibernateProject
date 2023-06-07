package cgg.hibernate.firstlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgg.hibernate.Student;

public class FirstLevelCacheDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student student = null;
		System.out.println(session.contains(student));
		student = session.get(Student.class, 14);
		System.out.println(session.contains(student));
		
		System.out.println("working something......");
		
		
		Student student1 = session.get(Student.class, 14);
		System.out.println(student1);
		
		System.out.println(session.contains(student1));
		
		session.close();
		factory.close();

	}

}
