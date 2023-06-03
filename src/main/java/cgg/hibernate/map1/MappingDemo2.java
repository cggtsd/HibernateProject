package cgg.hibernate.map1;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setEmpName("abc");

		Employee emp1 = new Employee();
		emp1.setEmpId(2);
		emp1.setEmpName("def");

		Project pro = new Project();
		pro.setProjectId(11);
		pro.setProjectName("Library Management");

		Project pro1 = new Project();
		pro1.setProjectId(22);
		pro1.setProjectName("ChatBot");

		ArrayList<Employee> list1 = new ArrayList<Employee>();
		list1.add(emp);
		list1.add(emp1);

		ArrayList<Project> list2 = new ArrayList<Project>();
		list2.add(pro);
		list2.add(pro1);

		emp.setProjects(list2);
		pro1.setEmployees(list1);
	   
		Transaction  tx = s.beginTransaction();
	    
		s.save(pro);
	    s.save(pro1);
	    s.save(emp);
	    s.save(emp1);
	    
	    tx.commit();
	    
	    Employee  e1 = s.get(Employee.class,1);
	    System.out.println(e1.getEmpName());
	    for (Project project : e1.getProjects()) {
			System.out.println(project.getProjectName());
		}
	    System.out.println("--------------------------");
	    Project  p1 = s.get(Project.class,22);
	    System.out.println(p1.getProjectName());
	    for (Employee employee: p1.getEmployees()) {
	    	System.out.println(employee.getEmpName());
			
		}
		s.close();
		factory.close();

	}

}
