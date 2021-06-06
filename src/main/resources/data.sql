create table currency_exchange(
id int not null,
currency_from varchar(20) not null,
currency_to varchar(20) not null,
conversion_multiple decimal(10,2) not null,
environment varchar(20)
);

insert into currency_exchange
(id,currency_from,currency_to,conversion_multiple,environment)
values(10001,'USD','INR',65,'');
insert into currency_exchange
(id,currency_from,currency_to,conversion_multiple,environment)
values(10002,'EUR','INR',75,'');
insert into currency_exchange
(id,currency_from,currency_to,conversion_multiple,environment)
values(10003,'AUD','INR',25,'');