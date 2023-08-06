/*третя нормальна форма*/

Drop database if exists Task_2;
create database Task_2;
use Task_2;
alter database Task_2 character set utf8mb4;


create table Звітність_отримавших_зброю
(
ID int auto_increment not null,
ПІБ varchar(30) not null,
Офіс int,
Взвод int not null,
primary key (ID)
);

create table Звітність_видавших_зброю
(
ID int auto_increment not null,
Звання varchar(20),
ПІБ varchar(30) not null,
primary key (ID)
);

create table Звітність_виданної_зброї
(
Зброю_отримав_ID int not null,
Зброю_видав__ID int not null,
Зброя varchar(20) not null,
primary key (Зброю_отримав_ID, Зброю_видав__ID),
foreign key (Зброю_отримав_ID) references Звітність_отримавших_зброю(ID),
foreign key (Зброю_видав__ID) references Звітність_видавших_зброю(ID)
);



insert into Звітність_отримавших_зброю
(ПІБ, Офіс, Взвод)
values
('Петров В.А.', 205, 222),
('Лодарев П.С.', 221, 232),
('Іващенко А.А.', 201, 212),
('Духов Р.М.', null, 200);

insert into Звітність_видавших_зброю
(Звання, ПІБ)
values
('майор', 'Буров О.С.'),
('майор', 'Рибаков Н.Г.'),
('підполковник', 'Деребанов В.Я.');

insert into Звітність_виданної_зброї
(Зброю_отримав_ID, Зброю_видав__ID, Зброя)
values
(1, 1, 'АК-47'),
(1, 2, 'Глок20'),
(2, 3, 'АК-47'),
(2, 2, 'Глок20'),
(3, 1, 'АК-47'),
(3, 2, 'Глок20'),
(4, 1, 'АК-47');


select * from Звітність_отримавших_зброю;
select * from Звітність_видавших_зброю;
select * from Звітність_виданної_зброї;