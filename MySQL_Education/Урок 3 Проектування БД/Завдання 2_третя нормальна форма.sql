/*третя нормальна форма*/
Drop database if exists Task_2;

create database Task_2;
alter database Task_2 character set utf8mb4;
use Task_2;


create table Offices
(
ID int auto_increment not null,
Office int not null,
primary key (ID)
);

create table Platoons
(
ID int auto_increment not null,
Platoon int not null,
primary key (ID)
);


create table Receivers_of_weapons
(
ID int auto_increment not null,
Full_name varchar(30) not null,
Office_ID int,
Platoon_ID int not null,
primary key (ID),
foreign key (Office_ID) references Offices(ID),
foreign key (Platoon_ID) references Platoons(ID)
);

create table Military_ranks
(
ID int auto_increment not null,
Military_rank varchar(20) not null,
primary key (ID)
);

create table Arms_іssuers
(
ID int auto_increment not null,
Military_rank_ID int not null,
Full_name varchar(30) not null,
primary key (ID),
foreign key (Military_rank_ID) references Military_ranks(ID)
);

create table Weapons
(
ID int auto_increment not null,
Weapon varchar(20) not null,
primary key (ID)
);

create table Issued_arms_reporting
(
Received_weapon_ID int not null,
Issued_weapon_ID int not null,
Weapon_ID int not null,
primary key (Received_weapon_ID, Issued_weapon_ID, Weapon_ID),
foreign key (Received_weapon_ID) references Receivers_of_weapons(ID),
foreign key (Issued_weapon_ID) references Arms_іssuers(ID),
foreign key (Weapon_ID) references Weapons(ID)
);



insert into Offices
(Office)
values
(205),(221),(201);

insert into Platoons
(Platoon)
values
(222),(232),(212),(200);

insert into Receivers_of_weapons
(Full_name, Office_ID, Platoon_ID)
values
('Петров В.А.', 1, 1),
('Лодарев П.С.', 2, 2),
('Іващенко А.А.', 3, 3),
('Духов Р.М.', null, 4);

insert into Military_ranks
(Military_rank)
values
('майор'),('підполковник');

insert into Arms_іssuers
(Military_rank_ID, Full_name)
values
(1, 'Буров О.С.'),
(1, 'Рибаков Н.Г.'),
(2, 'Деребанов В.Я.');

insert into Weapons
(Weapon)
values
('АК-47'),('Глок20');

insert into Issued_arms_reporting
(Received_weapon_ID, Issued_weapon_ID, Weapon_ID)
values
(1, 1, 1),
(1, 2, 2),
(2, 3, 1),
(2, 2, 2),
(3, 1, 1),
(3, 2, 2),
(4, 1, 1);


select * from Offices;
select * from Platoons;
select * from Receivers_of_weapons;
select * from Military_ranks;
select * from Arms_іssuers;
select * from Weapons;
select * from Issued_arms_reporting;