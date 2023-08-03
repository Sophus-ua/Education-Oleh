create database cars;

use cars;

create table info
(
id int auto_increment not null,
make varchar(15) not null,
model varchar(15) not null,
engine_volume float not null,
price int  not null,
max_speed int  not null,
primary key (id)
);

insert into info (make, model, engine_volume, price, max_speed) values
('Toyota', 'Corolla', 1.8, 24000, 180),
('Honda', 'Civic', 1.6, 22000, 200),
('Mazda', '6', 2.2, 23000, 190);

select * from info;