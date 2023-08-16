delimiter |
use carsshop; |

create function client_min_age()
returns tinyint
reads sql data
begin

return(
   select min(age) from clients
);

end; |

select c.name, m.mark, ca.model from clients as c
join orders as o on o.client_id = c.id
join cars as ca on ca.id = o.car_id 
join marks as m on m.id = ca.mark_id
where c.age = client_min_age(); |
