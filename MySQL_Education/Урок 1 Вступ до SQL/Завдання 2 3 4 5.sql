create database MyDB;

use MyDB;

create table List_of_employees
(
id int auto_increment not null,
name varchar(30) not null,
phone varchar(15) not null,
primary key (id)
);

create table Position_of_employees
(
id int auto_increment not null,
position varchar(30) not null,
salary int not null,
primary key (id)
);

create table Personal_data
(
id int auto_increment not null,
date_of_birth date not null,
marital_status ENUM('заміжня','одружений','неодружений','незаміжня') not null ,
place_of_residence varchar(50) not null,
primary key (id)
);

insert into List_of_employees (name, phone) values
('Петренко Петров', +380505554433),
('Іван Іванов', +380939332211),
('Ганна Кирилівна', +380939332211);

insert into Position_of_employees (position, salary) values
('manager', 12000),
('engineer', 9000),
('accountant',14000);

insert into Personal_data (date_of_birth, marital_status, place_of_residence) values
('1990-07-18','неодружений', 'Kyiv'),
('2005-06-17','одружений','Odesa'),
('2001-05-15','заміжня','Lviv');

select * from MyDB.Position_of_employees where salary> 10000;

update Personal_data set marital_status = 'одружений' where id = 1;
