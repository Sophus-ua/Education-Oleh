create database Human_resources_department;

use Human_resources_department;

create table Departments
(
id int auto_increment not null,
department_name varchar(30) not null,
phone_of_department varchar(15) not null,
primary key (id)
);

create table Job_titles
(
id int auto_increment not null,
job_title_name varchar(30) not null,
job_title_description varchar(50) not null,
department_ID int not null,
primary key (id),
foreign key (department_ID) references Departments(id)
);

create table Employees_data
(
id int auto_increment not null,
name varchar(30) not null,
job_title_ID int not null,
gender varchar(30) not null,
date_of_birth date not null,
date_of_employment date not null,
address varchar(15) not null,
phone varchar(15) not null,
primary key (id),
foreign key (job_title_ID) references Job_titles(id)
);

create table Salary
(
id int auto_increment not null,
job_title_ID int not null,
salary_amount int not null, 
date_issued date not null,
primary key (id),
foreign key (job_title_ID) references Job_titles(id)
);

create table Vacancies
(
id int auto_increment not null,
job_title_ID int not null,
vacancy_description varchar(50) not null, 
date_posted date not null,
primary key (id),
foreign key (job_title_ID) references Job_titles(id)
);