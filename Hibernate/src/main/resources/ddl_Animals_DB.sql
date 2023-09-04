drop database if exists Animals;

create database Animals;

use Animals;

create table animals
(
id int auto_increment not null,
age int,
name nvarchar(20) not null,
tail boolean,
constraint pk_animal_id primary key (id)
);


delimiter |
delete from animals;
ALTER TABLE animals AUTO_INCREMENT=1;|
