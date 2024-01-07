create database sample2;
use sample2;
create table employee(
	employeeId varchar(20) primary key,
    employeeName varchar(20),
    employeeAddress varchar(20),
    employeePhone varchar(20),
    employeeSalary int,
    employeeTax float
);
drop table employee;
truncate employee;
desc employee;
select * from employee;