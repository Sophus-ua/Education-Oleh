create database Wholesale_warehouse;

use Wholesale_warehouse;

create table Employees
(
id int auto_increment not null,
name varchar(30) not null,
phone varchar(15) not null,
years_of_employment int not null,
position varchar(15) not null,
primary key (id)
);


create table Customers
(
id int auto_increment not null,
sales_manager_ID int not null,
company_name varchar(30) not null, 
name_contact_person varchar(30) not null,
phone_contact_person varchar(15) not null,
primary key (id),
foreign key (sales_manager_ID) references employees(id)
);

create table Suppliers
(
id int auto_increment not null,
sales_manager_ID int not null,
company_name varchar(30) not null, 
name_contact_person varchar(30) not null,
phone_contact_person varchar(15) not null,
primary key (id),
foreign key (sales_manager_ID) references employees(id)
);

create table List_products
(
id int auto_increment not null,
supplier_ID int not null,
name_of_product varchar(30) not null,
numbers int not null,
weight double not null,
volume double not null,
primary key (id),
foreign key (supplier_ID) references suppliers(id)
);

create table Customers_products
(
customer_ID int not null,
product_ID int not null,
primary key (customer_ID, product_ID),
foreign key (customer_ID) references Customers(id),
foreign key (product_ID) references List_products(id)
);