package cgg.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgg.hibernate.Student;

public class HQLDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		
		//HQL
		//Syntax
		
		String query = "from Student  s where s.city = :x and s.name=:n";
		Query q = session.createQuery(query);
		q.setParameter("x", "Hyd");
		q.setParameter("n", "ABC");
		
		//single result - (unique)
		//multiple result - list
		
		List<Student> list = q.list();
		
		for (Student student : list) {
			System.out.println(student.getName()+":"+student.getCity()+":"+student.getCerti().getCourse());
		}
		
		session.close();
		factory.close();

	}

}
