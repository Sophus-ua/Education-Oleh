delimiter |
drop database if exists Catalogue_of_necklaces;|

create database Catalogue_of_necklaces;|

use Catalogue_of_necklaces;|

create table List_of_necklaces
(
id int unique not null,
name nvarchar(30),
constraint pk_id primary key (id) 
); |

create table Gems
(
necklace_ID int not null,
count int not null,
typeName nvarchar(30) not null,
caratWeight double not null,
clarity int not null,
colorSaturation int not null,
constraint fk_necklace_id foreign key (necklace_ID) references List_of_necklaces(ID)
on delete cascade on update cascade
); |

create index necklace_id on Gems(necklace_ID);

