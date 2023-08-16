delimiter |
drop database if exists MyFunkDB; |

create database MyFunkDB; 
use MyFunkDB; |



/* створення таблиць */
create table Job_position
(
ID int auto_increment not null,
position_name varchar(30) not null,
base_salary double,
constraint pk_id primary key (ID)
); 

create table Employees
(
ID int auto_increment not null,
First_name varchar(20) not null,
Last_name varchar(20) not null,
position_ID int not null,
phone varchar(15) not null,
constraint pk_id primary key (ID),
constraint fk_position_id foreign key (position_ID) references Job_position(ID)
);

create table Personal_info
(
employees_ID int,
date_of_birth date not null,
address varchar(100) not null,
marital_status varchar(30),
constraint fk_employees_id foreign key (employees_ID) references Employees(ID)
); |



/* заповнення таблиць */
insert into Job_position
(position_name, base_salary)
values
('Chief_director', 10000),
('Manager', 2500),
('Worker', 1500);

insert into Employees
(First_Name, Last_Name, position_ID, phone)
values
('Kiril','Kravchenko',3 ,'+3805041818'),
('Petro','Simonenko',1 ,'+3805041414'),
('Oksana','Kush',2 ,'+3805041212');

insert into Personal_info
(employees_ID, date_of_birth, address, marital_status)
values
(1,'1990-07-11','Kiev, Perova 4, ap. 45', 'Unmarried'),
(3,'2000-08-12','Lviv, Staroievreiska 5, ap. 12', 'Married '),
(2,'2003-09-14','Kiev, Bazana 11, ap. 112', 'Married '); |



/* створення процедур */
create procedure Employees_phone_address()
begin

select e.First_name, e.Last_name, e.phone, pi.address 
from Employees as e
join Personal_info as pi on pi.employees_ID = e.id;

end; 


create procedure Unmarrieds_privat_info()
begin

select e.First_name, e.Last_name, pi.date_of_birth, e.phone 
from Employees as e 
join Personal_info as pi on pi.employees_ID = e.id
where pi.marital_status like 'Unmarried';

end; 

create procedure Managers_privat_info()
begin

select e.First_name, e.Last_name, pi.date_of_birth, e.phone
from Employees as e 
join Personal_info as pi on pi.employees_ID = e.id
join Job_position as jp on jp.ID = e.position_ID
where jp.position_name = 'manager';

end; |



/* виклик процедур */
call Employees_phone_address(); |
call Unmarrieds_privat_info(); |
call Managers_privat_info(); |

