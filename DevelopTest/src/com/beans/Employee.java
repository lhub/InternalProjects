package com.beans;

public class Employee implements Comparable<Employee>
{
	private int empId;
	private String empName;
	private String empDesignation;
	private String empDepartment;
	private String empProject;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpDesignation() {
		return empDesignation;
	}
	
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	
	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	
	public String getEmpProject() {
		return empProject;
	}
	
	public void setEmpProject(String empProject) {
		this.empProject = empProject;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.empId - o.empId ;
	}
	
	

}
