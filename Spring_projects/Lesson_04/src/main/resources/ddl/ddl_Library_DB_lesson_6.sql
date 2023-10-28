delimiter |
drop database if exists library;|


create database library;|

use library;|

CREATE TABLE author
(
    id INT NOT NULL AUTO_INCREMENT,
    first_name nVARCHAR(45),
    last_name nvarchar(45),
    constraint pk_id primary key (id)
);|

CREATE TABLE book
(
    id INT NOT NULL AUTO_INCREMENT,
    title nVARCHAR(45),
    constraint pk_id primary key (id)
);|

create table authors_books
(
author_id int,
book_id int,
constraint pk_authors_books primary key (author_id, book_id),
constraint fk_author_id foreign key (author_id) references author(id)
on delete cascade on update cascade,
constraint fk_book_id foreign key (book_id) references book(id)
on delete cascade on update cascade
);|



delete from book;
delete from author;
ALTER TABLE book AUTO_INCREMENT=1;
ALTER TABLE author AUTO_INCREMENT=1;|