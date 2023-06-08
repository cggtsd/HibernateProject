package cgg.hibernate.secondlevelcache;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgg.hibernate.Student;
import cgg.hibernate.map.Brand;
import cgg.hibernate.map.Product;

public class Test {
public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	Session session = factory.openSession();
	
	Brand b1 = session.get(Brand.class, 5);
	System.out.println(b1.getBrandName());
	List<Product> products = b1.getProducts();
	for (Product product : products) {
		System.out.println(product.getProductName());
	}
	session.close();
	
	Session session2 = factory.openSession();
	Brand b2 = session2.get(Brand.class, 5);
	System.out.println(b2.getBrandName());
	List<Product> products1 = b2.getProducts();
	for (Product product : products1) {
		System.out.println(product.getProductName());
	}
	session2.close();
		
	factory.close();
	
}
}
