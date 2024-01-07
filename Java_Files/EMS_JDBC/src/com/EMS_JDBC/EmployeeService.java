package com.EMS_JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeService {

	EmployeeDAO dao;
	
	public EmployeeService(String url, String username, String password){
		
		dao = new EmployeeDAO();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dao.con = DriverManager.getConnection(url, username, password);
			dao.stmt = dao.con.createStatement();
		}
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	public ArrayList <Employee> getEmployeeRecords(){
		return dao.getAllEmployees();
	}
	
	public Employee searchEmployeeById(String empId){
		return dao.getEmployeeById(empId);
	}
	
	public boolean insertEmployeeRecord(Employee emplI){
		return dao.insertEmployee(emplI);
	}
	
	public boolean updateEmployeeRecord(Employee emplU){
		return dao.updateEmployee(emplU);
	}
	
	public boolean deleteEmployeeRecord(String empId){
		return dao.deleteEmployeeById(empId);
	}
	
	public ArrayList <String> getAllEmployeeIds(){
		return dao.getEmployeeIds();
	}
	
	public boolean disconnect() {
		return dao.disconnect();
	}
	
}
