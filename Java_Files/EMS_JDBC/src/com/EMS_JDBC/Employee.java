package com.EMS_JDBC;

public class Employee {

	private String employeeId;
	private String employeeName;
	private String employeeAddress;
	private String employeePhone;
	private int employeeSalary;
	private float employeeTax;
	
	public Employee(String employeeId, String employeeName, String employeeAddress, String employeePhone, int employeeSalary, float employeeTax) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
		this.employeeSalary = employeeSalary;
		this.employeeTax = employeeTax;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public int getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public float getEmployeeTax() {
		return employeeTax;
	}
	public void setEmployeeTax(float employeeTax) {
		this.employeeTax = employeeTax;
	}
	
}
