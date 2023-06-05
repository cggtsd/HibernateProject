package cgg.hibernate.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 
		 
			/*
			 * Brand b = new Brand(); b.setBrandId(1); b.setBrandName("Dell");
			 * 
			 * Product p = new Product(); p.setProductId(11); p.setProductName("Laptop");
			 * p.setBrand(b);
			 * 
			 * Product p1 = new Product(); p1.setProductId(12);
			 * p1.setProductName("Desktop"); p1.setBrand(b);
			 * 
			 * Product p2 = new Product(); p2.setProductId(13); p2.setProductName("MOuse");
			 * p2.setBrand(b);
			 * 
			 * List<Product> pro = new ArrayList<Product>();
			 * 
			 * pro.add(p2); pro.add(p1); pro.add(p);
			 * 
			 * b.setProducts(pro);
			 */
		 
		 Session session = factory.openSession();
		 
		 //Transaction tx = session.beginTransaction();
			/*
			 * session.save(b); session.save(p); session.save(p1); session.save(p2);
			 */
		 
		 
		 //tx.commit();
		 
		 
		 Brand b1 = session.get(Brand.class, 1);
		// List<Product> products = b1.getProducts();
		 System.out.println(b1.getBrandName());
		 //System.out.println(b1.getProducts().size());
			/*
			 * for(Product prod: products ) { System.out.println(prod.getProductName()); }
			 */
		 
		 session.close();
		 
		 factory.close();

	}

}
