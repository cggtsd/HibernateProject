package cgg.hibernate.map1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@Column(name = "project_id")

	private int projectId;
	@Column(name = "project_name")
	private String projectName;
	
	@ManyToMany(mappedBy="projects")
	private List<Employee> employees;

	public int getProjectId() {
		return projectId;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Project(int projectId, String projectName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
}
