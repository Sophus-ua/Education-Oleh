drop database if exists Human_resources_Department;

create database Human_resources_Department;
use Human_resources_Department;


create table Departments
(
ID int auto_increment not null,
Department_name varchar(30) not null,
Head_ID int not null,
Phone varchar(20),
Office_number int,
primary key (ID)
);

create table Positions
(
ID int auto_increment not null,
Department_ID int not null,
Position_name varchar(30) not null,
Brief_description varchar(50),
Salary float(20,2) not null,
primary key (ID),
foreign key (Department_ID) references Departments(ID)
);

create table Employees
(
ID int auto_increment not null,
Position_ID int not null,
Last_name varchar(30) not null,
First_name varchar(20) not null,
Date_of_birth date not null,
Address varchar(50) not null,
Phone varchar(20) not null,
Email varchar(20) not null,
Hire_date date not null,
primary key (ID),
foreign key (Position_ID) references Positions(ID)
);

alter table Departments
add constraint fk_Head_ID
foreign key (Head_ID) references Employees(ID);

create table Vacancies
(
ID int auto_increment not null,
Position_ID int not null,
Vacancie_title varchar(30) not null,
Vacancie_description varchar(50) not null, 
primary key (ID),
foreign key (Position_ID) references Positions(ID)
);