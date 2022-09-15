# sales-backend
--Realizé la parte del BACK y DB, ya que por parte del FRONT tuve algunos problemas de mi máquina, los puertos se cambiaban constantemente y se me complicaba bastante al trabajar con LARAVEL por la parte del FRONT, ya que tenía que utilizar apache y no reconocía ningún puerto.

DATABASE: 
![image](https://user-images.githubusercontent.com/101606140/190525053-5f92e685-f553-44ea-b735-354f59aa1bce.png)

SCRIPT: 

drop database if exists sales;
create database sales;
use sales;

create table if not exists customers
(
	cod_customer integer unsigned not null AUTO_INCREMENT,
	name_customer varchar(50) not null,
   last_name_customer varchar(50) not null,
   city_customer varchar(50) not null,
	primary key(cod_customer)
);

insert into customers (name_customer,last_name_customer,city_customer) values ('Jackson','Smith','Nueva York');
insert into customers (name_customer,last_name_customer,city_customer) values ('Lucas','Johnson','Chicago');
insert into customers (name_customer,last_name_customer,city_customer) values ('Joe','Williams','Boston');
insert into customers (name_customer,last_name_customer,city_customer) values ('Noah','Jones','Miami');


create table if not exists products
(
	cod_product int unsigned not null auto_increment,
	name_product varchar(50) not null,
   category_product varchar(50) not null,
   price_product decimal(10,2) DEFAULT 0.0,
   status_product enum('Active','Inactive') not null default 'Active',
	primary key(cod_product)
);


insert into products (name_product,category_product,price_product) values ('Coco Cola','Beverages',5.5);
insert into products (name_product,category_product,price_product)  values ('Chocolate','Candy',10);
insert into products (name_product,category_product,price_product)  values ('Chocolate chip cookie','Cookies',5);
insert into products (name_product,category_product,price_product) values ('Chocolate cake','Cakes',25);


create table if not exists orders
(
	cod_order int unsigned not null auto_increment,
	date_order timestamp default current_timestamp(),
   cod_customer int unsigned not null,
   status_order enum('Active','Inactive')default 'Active',
   total_order decimal(10,2) not null,
   taxes_order decimal(10,2) not null,
   sub_total decimal(10,2) not null,
	primary key(cod_order),
	constraint fk_ord_cust
   foreign key (cod_customer) 
   references customers (cod_customer) 
);


create table if not exists details_orders (
	cod_det_ord int unsigned not null auto_increment,
	cod_order	int unsigned not null,
	cod_product	int unsigned not null,
	quantity int not null,
   importe decimal(10,2) not null,
	primary key (cod_det_ord,cod_order,cod_product),
	constraint fk_det_prod
   foreign key (cod_product) 
   references products (cod_product) 
   on delete cascade 
   on update cascade,
   constraint fk_det_order
   foreign key (cod_order) 
   references orders (cod_order) 
   on delete cascade 
   on update cascade 
);
