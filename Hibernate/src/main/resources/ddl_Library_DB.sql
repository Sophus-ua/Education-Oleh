drop database if exists library;

create database library;

use library;

CREATE TABLE author
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(45)
);

CREATE TABLE book
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    author_id INT(11),
    foreign key (author_id) references author(id)
);

delimiter |
delete from book;
delete from author;
ALTER TABLE book AUTO_INCREMENT=1;
ALTER TABLE author AUTO_INCREMENT=1;|