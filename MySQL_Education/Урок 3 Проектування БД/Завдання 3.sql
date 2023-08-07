drop database if exists Human_resources_Department;

create database Human_resources_Department;
use Human_resources_Department;



create table Departments
(
ID int auto_increment not null,
Department_name varchar(30) not null,
Phone varchar(20),
Office_number int,
primary key (ID)
);


create table Positions
(
ID int auto_increment not null,
Position_name varchar(30) not null,
Brief_description varchar(50),
primary key (ID)
);


create table Employees
(
ID int auto_increment not null,
Last_name varchar(30) not null,
First_name varchar(20) not null,
Date_of_birth date not null,
Address varchar(50),
Phone varchar(20) not null,
Email varchar(20),
Account_for_payments int not null unique,
Hire_date date not null,
Termination_date date,
primary key (ID, Account_for_payments)
);


create table Positions_of_employees_in_departments
(
Start_date date not null,
Department_ID int not null,
Position_ID int not null,
Employee_ID int not null,
Base_salary double not null,
End_date date, 
primary key (Start_date, Department_ID, Position_ID, Employee_ID),
foreign key (Department_ID) references Departments(ID),
foreign key (Position_ID) references Positions(ID),
foreign key (Employee_ID) references Employees(ID)
);


create table Salary_paid
(
Payment_ID int not null unique,
Employee_ID int not null,
Total_base_salary double not null,
Bonuses_and_additional_compensation double,
Deductions_and_withholdings double,
Payment_date date not null,
primary key (Payment_ID),
foreign key (Employee_ID) references Employees(ID)
);


create table Vacancies
(
ID int auto_increment not null,
Position_ID int not null,
Vacancie_title varchar(30) not null,
Vacancie_description varchar(50) not null, 
primary key (ID),
foreign key (Position_ID) references Positions(ID)
);




select * from Departments;
select * from Positions;
select * from Employees;
select * from Positions_of_employees_in_departments;
select * from Salary_paid;
select * from Vacancies;