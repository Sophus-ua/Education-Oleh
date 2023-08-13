USE ShopDB;

explain select fname from customers where lname like 'лев%' ;      /*FITERED 20*/      
explain select fname from customers where phone = '(053)3456788';  /*FITERED 20*/   


alter table customers
add ID int auto_increment not null primary key;
explain select fname from customers where id = 2 ;                 /*FITERED 100*/
explain select fname from customers where lname like 'лев%' ;      /*FITERED 20*/
explain select fname from customers where phone = '(053)3456788';  /*FITERED 20*/


create index lname on customers(lname);
explain select fname from customers where lname like 'лев%' ;      /*FITERED 100*/
explain select fname from customers where phone = '(053)3456788';  /*FITERED 20*/

create unique index phone on customers(phone);
explain select fname from customers where lname like 'лев%' ;      /*FITERED 100*/
explain select fname from customers where phone = '(053)3456788' ; /*FITERED 100*/

