/*друга нормальна форма*/

Drop database if exists Task_2;
create database Task_2;
use Task_2;
alter database Task_2 character set utf8mb4;


create table Звітність_отримавших_зброю
(
ID int auto_increment not null,
ПІБ varchar(30) not null,
Взвод int not null,
Офіс int,
primary key (ID)
);

create table Звітність_видавших_зброю
(
ID int auto_increment not null,
Зброю_отримав_ID int not null,
Звання varchar(20),
ПІБ varchar(30) not null,
Зброя varchar(20) not null,
primary key (ID),
foreign key (Зброю_отримав_ID) references Звітність_отримавших_зброю(ID)
);


insert into Звітність_отримавших_зброю
(ПІБ, Взвод, Офіс)
values
('Петров В.А.', 222, 205),
('Лодарев П.С.', 232, 221),
('Іващенко А.А.', 212, 201),
('Духов Р.М.', 200, null);

insert into Звітність_видавших_зброю
(Зброю_отримав_ID, Звання, ПІБ, Зброя)
values
(1, 'майор', 'Буров О.С.', 'АК-47'),
(1, 'майор', 'Рибаков Н.Г.', 'Глок20'),
(2, 'підполковник', 'Деребанов В.Я.', 'АК-74'),
(2, 'майор', 'Рибаков Н.Г.', 'Глок20'),
(3, 'майор', 'Буров О.С.', 'АК-47'),
(3, 'майор', 'Рибаков Н.Г.', 'Глок20'),
(4, 'майор', 'Буров О.С.',  'АК-47');


select * from Звітність_отримавших_зброю;
select * from Звітність_видавших_зброю;