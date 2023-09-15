use test_base_lesson1;

create table Job_position 
(
ID int auto_increment not null, 
 position_name varchar(30) not null, 
base_salary double, 
constraint pk_id primary key (ID)
);


insert into Job_position 
(position_name, base_salary) 
values 
('Chief_director', 10000), 
('Manager', 2500), 
('Worker', 1500); 

Update Job_position 
set base_salary = 12000 where position_name = 'Chief_director';

alter table Job_position 
add bonus int;

select * from Job_position;





