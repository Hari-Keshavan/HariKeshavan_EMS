package com.EMS_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDAO {

	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	ArrayList<Employee> employees;
	Employee employee;
	
	public ArrayList <Employee> getAllEmployees(){
		
		employees = new ArrayList<Employee>();
		
		String query = "select * from employee";
		
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				employees.add(new Employee(rs.getString("employeeId"), rs.getString("employeeName"), rs.getString("employeeAddress"), rs.getString("employeePhone"), rs.getInt("employeeSalary"), rs.getFloat("employeeTax")));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if (employees.size()>0) {
			return employees;
		}
		return null;
		
	}
	
	public Employee getEmployeeById(String empId){
		
		String query = "select * from employee where employeeId = '" + empId + "'";
		
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				employee = new Employee (rs.getString("employeeId"), rs.getString("employeeName"), rs.getString("employeeAddress"), rs.getString("employeePhone"), rs.getInt("employeeSalary"), rs.getFloat("employeeTax"));
				
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return employee;
		
	}
	
	public boolean deleteEmployeeById(String empId){
		
		String query = "delete from employee where employeeId = '" + empId + "'";
		
		try {
			return stmt.execute(query);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean updateEmployee(Employee empU){
		
		try {
			pstmt = con.prepareStatement("update employee set employeeName = ?, employeeAddress = ?, employeePhone = ?, employeeSalary = ?, employeeTax = ? where employeeId = ?");
			
			pstmt.setString(1, empU.getEmployeeName());
			pstmt.setString(2, empU.getEmployeeAddress());
			pstmt.setString(3, empU.getEmployeePhone());
			pstmt.setInt(4, empU.getEmployeeSalary());
			pstmt.setFloat(5, empU.getEmployeeTax());
			pstmt.setString(6, empU.getEmployeeId());
			
			pstmt.execute();
			pstmt.close();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean insertEmployee(Employee empI){
		
		try {
			pstmt = con.prepareStatement("insert into employee values (?,?,?,?,?,?)");
			
			pstmt.setString(1, empI.getEmployeeId());
			pstmt.setString(2, empI.getEmployeeName());
			pstmt.setString(3, empI.getEmployeeAddress());
			pstmt.setString(4, empI.getEmployeePhone());
			pstmt.setInt(5, empI.getEmployeeSalary());
			pstmt.setFloat(6, empI.getEmployeeTax());
			
			pstmt.execute();
			pstmt.close();
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ArrayList <String> getEmployeeIds(){
		
		ArrayList<String> idList = new ArrayList<String>();
		
		String query = "select employeeId from employee";
		
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				idList.add(rs.getString("employeeId"));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return idList;
		
	}
	
	public boolean disconnect() {
		try {
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}
