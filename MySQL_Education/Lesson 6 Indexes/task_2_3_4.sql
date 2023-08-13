use MyJoinsDB;

/*
table 'Positions' field (ID) primary key  -  кластеризований індекс
table 'Employees_private_information' field (ID) primary key  -  кластеризований індекс
table 'Employees' field (ID) primary key  -  кластеризований індекс
*/

create index Position_name on Positions(Position_name);
/*часто пошук може бути по назві посади*/

create index Date_of_birth on Employees_private_information(Date_of_birth);
/*фільтрація по дню народження для якихось поздоровлень,бонусів і т.д.*/

create index City on Employees_private_information(City);
/*фільтрація робітників по місту проживання*/

create index Last_Name on Employees(Last_Name);
/*пошук по фамілії*/



create view contact_details
as select e.First_Name, e.Last_Name, e.Phone, ep.CIty, ep.Address
from Employees as e
inner join Employees_private_information as ep on e.Private_info_ID = ep.id;

select * from contact_details;


create view Unmarried_employees_contacts
as select e.First_Name, e.Last_Name, ep.Date_of_birth, e.Phone
from  Employees as e
inner join Employees_private_information as ep on e.Private_info_ID = ep.id
where ep.Marital_status = 'Single';

select * from Unmarried_employees_contacts;


create view Managers_contacts
as select e.First_Name, e.Last_Name, ep.Date_of_birth, e.Phone
from Employees as e
inner join Employees_private_information as ep on e.Private_info_ID = ep.id
where (select Position_name from Positions as p where e.Position_ID = p.id) = 'Manager';

select * from Managers_contacts;





