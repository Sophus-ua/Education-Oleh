delimiter |
use MyFunkDB; |


/* створення транзакцій */
create procedure insertEmployeeTransaction
(
 in firstName varchar(20), 
 in lastName varchar(20), 
 in positionID int, 
 in _phone varchar(15)
 ) 
begin

declare employeeExists INT;
start transaction;
   insert into Employees (First_Name, Last_Name, position_ID, phone)
   values (firstName, lastName, positionID, _phone);
   select count(*) into employeeExists from Employees where First_Name = firstName and Last_Name = lastName;

   if  employeeExists > 1 then rollback;
   else commit; 
   end if;

end; |

call insertEmployeeTransaction /* вже існуючий працівник, не вставиться */
('Petro','Simonenko', 2 ,'+3805042727'); 
select * from employees; |

call insertEmployeeTransaction
('Lina','Stefania', 2 ,'+3805042828'); /* новий працівник, вставиться */
select * from employees; |




/* створення триггерів */
create trigger deleteEmployeeWhithPersonal_info
before delete on Employees
for each row
begin
delete from Personal_info where employees_ID = OLD.ID;
end; 

create trigger deleteEmployeeWhithJob_position
after delete on Employees
for each row
begin
delete from Job_position where ID = OLD.position_ID;
end; |

/* перед спрацюванням триггерів */
select * from Personal_info; |                                                 
select * from Job_position; |

/* видалення співробітника і спрацювання триггерів */
delete from Employees where First_Name = 'Petro' and last_name = 'Simonenko';  
select * from Personal_info; |
select * from Job_position; |










