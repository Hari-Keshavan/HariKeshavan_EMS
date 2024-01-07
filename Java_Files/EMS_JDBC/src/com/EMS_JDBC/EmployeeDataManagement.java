package com.EMS_JDBC;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDataManagement {
	
	public void showMenu() {
		
		int cont = 0;
		Scanner in = new Scanner(System.in);
		EmployeeService service = new EmployeeService("jdbc:mysql://localhost:3306/sample2", "root", "04262330");
		System.out.println("--------------------------------");
		System.out.println("Employee Details Management Menu");
		System.out.println("--------------------------------");
		
		while (cont != 6) {
			System.out.println();
			System.out.println("1.View All Employee Records");
			System.out.println("2.Search Employee Record by ID");
			System.out.println("3.Insert Employee Record");
			System.out.println("4.Delete Employee ID");
			System.out.println("5.Update Employee");
			System.out.println("6.Exit");
			System.out.println();
			System.out.print("Please Enter Your Option: ");
			cont = in.nextInt();
			
			if (cont == 1) {
				
				ArrayList<Employee> employees = service.getEmployeeRecords();
				if (employees == null) {
					System.out.println("No Record Found");
				}
				else {
					for (Employee temp : employees) {
						System.out.println("ID: " + temp.getEmployeeId() + "| Name: " + temp.getEmployeeName() + "| Address: " + temp.getEmployeeAddress() + "| Phone: " + temp.getEmployeePhone() + "| Salary: " + temp.getEmployeeSalary() + "| Tax: " + temp.getEmployeeTax());
					}
				}

			}
			
			else if (cont == 2) {
				
				in.nextLine();
				System.out.print("Enter Id: ");
				String id = in.nextLine();
				Employee emp = service.searchEmployeeById(id);
				if (emp == null) {
					System.out.println("No record found");
				}
				else {
					System.out.println("ID: " + emp.getEmployeeId() + "| Name: " + emp.getEmployeeName() + "| Address: " + emp.getEmployeeAddress() + "| Phone: " + emp.getEmployeePhone() + "| Salary: " + emp.getEmployeeSalary() + "| Tax: " + emp.getEmployeeTax());
				}
				
			}
			
			else if (cont == 3) {
				
				System.out.print("Enter Id: ");
				String empId = in.next();
				System.out.print("Enter Name: ");
				String empName = in.next();
				System.out.print("Enter Address: ");
				String empAddress = in.next();
				System.out.print("Enter Phone: ");
				String empPhone = in.next();
				System.out.print("Enter Salary: ");
				int empSalary = in.nextInt();
				System.out.print("Enter Tax: ");
				float empTax = in.nextFloat();
				
				boolean bool = service.insertEmployeeRecord(new Employee(empId, empName, empAddress, empPhone, empSalary, empTax));
				
				if (bool) {
					System.out.println("Inserted Successfully");
				}
				else {
					System.out.println("ID Already Present / Exception. Can't Insert");
				}
				
			}
			
			else if (cont == 4) {
				
				System.out.print("Enter Id: ");
				String id = in.next();
				boolean bool = service.deleteEmployeeRecord(id);
				
				if (bool) {
					System.out.println("Deleted Successfully");
				}
				else {
					System.out.println("ID Not Found. Can't Delete");
				}
				
			}
			
			else if (cont == 5) {
				
				System.out.print("Enter Id: ");
				String empId = in.next();
				System.out.print("Enter Name: ");
				String empName = in.next();
				System.out.print("Enter Address: ");
				String empAddress = in.next();
				System.out.print("Enter Phone: ");
				String empPhone = in.next();
				System.out.print("Enter Salary: ");
				int empSalary = in.nextInt();
				System.out.print("Enter Tax: ");
				float empTax = in.nextFloat();
				
				boolean bool = service.updateEmployeeRecord(new Employee(empId, empName, empAddress, empPhone, empSalary, empTax));
				
				if (bool) {
					System.out.println("Updated Successfully");
				}
				else {
					System.out.println("ID Not Found. Can't Update");
				}
				
			}
			
			else if (cont == 6) {
				if (service.disconnect()) {
					System.out.println("Disconnected Successfully.\nExiting the system. Goodbye!");
				}
				else {
					System.out.println("Problem in Disconnection.\nExiting the system. Goodbye!");
				}
				break;
				
			}
			
			else {
				
				System.out.println("Enter correct option!");
				continue;
				
			}			
			
			
		}
		
		in.close();
		
	}

}
