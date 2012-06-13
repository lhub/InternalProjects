package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.Employee;

public class EmpDao {

	public List<Employee> getAllRecords() 
	{
		List<Employee> uList = new ArrayList<Employee>();
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/employee";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected to the database");

			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM  employee.empdetails");

			while (res.next())
			{
				Employee emp = new Employee();
				String empId = res.getString("empId");
				String empName = res.getString("empName");
				String empDesignation = res.getString("empDesignation");
				String empDepartment = res.getString("empDepartment");
				String empProject = res.getString("empProject");

				emp.setEmpId(new Integer(empId));
				emp.setEmpName(empName);
				emp.setEmpDesignation(empDesignation);
				emp.setEmpDepartment(empDepartment);
				emp.setEmpProject(empProject);
				uList.add(emp);
			}
			System.out.println("size of emp : " + uList.size());
			conn.close();
			System.out.println("Disconnected from database");
			return uList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
