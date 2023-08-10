drop database if exists MyJoinsDB;

create database MyJoinsDB;
use MyJoinsDB;


create table Positions
(
ID int auto_increment not null,
Position_name varchar(30) not null,
Base_salary double(10,2) not null,
primary key (ID)
);

create table Employees_private_information
(
ID int auto_increment not null,
Date_of_birth date not null,
City varchar(10) not null,
Address varchar(50) not null,
Marital_status varchar(20) not null, 
primary key (ID)
);

create table Employees
(
ID int auto_increment not null,
First_Name varchar(30) not null,
Last_Name varchar (30) not null,
Phone varchar (20) not null,
Private_info_ID int not null,
Position_ID int not null,
primary key (ID),
foreign key (Position_ID) references Positions(ID),
foreign key (Private_info_ID) references Employees_private_information(ID)
);


insert into Positions
(Position_name, Base_salary)
values
('Chief_director', 10000),
('Manager', 2500),
('Worker', 1500);


insert into Employees_private_information
(Date_of_birth, City, Address, Marital_status)
values
('1990-07-11','Kiev','Perova 4, ap. 45','Single'),
('2000-08-12','Lviv','Staroievreiska 5, ap. 12','Married '),
('2003-09-14','Kiev','Bazana 11, ap. 112','Married ');


insert into Employees
(First_Name, Last_Name, Phone, Private_info_ID, Position_ID)
values
('Kiril','Kravchenko','+3805041818',1,3),
('Petro','Simonenko','+3805041414',2,1),
('Oksana','Kush','+3805041212',3,2);






select e.First_Name, e.Last_Name, e.Phone, 
(select ep.City from Employees_private_information as ep where e.Private_info_ID = ep.ID) as City,
(select ep.Address from Employees_private_information as ep where e.Private_info_ID = ep.ID) as Address
from Employees as e;

select e.First_Name, e.Last_Name, e.Phone, 
(select ep.Date_of_birth from Employees_private_information as ep where e.Private_info_ID = ep.ID) as Date_of_birth
from Employees as e
where (select ep.Marital_status from Employees_private_information as ep where e.Private_info_ID = ep.ID) 
like 'Single';

select e.First_Name, e.Last_Name, e.Phone, 
(select ep.Date_of_birth from Employees_private_information as ep where e.Private_info_ID = ep.ID) as Date_of_birth
from Employees as e
where (select p.Position_name from Positions as p where e.Position_ID = p.ID) 
= 'Manager';