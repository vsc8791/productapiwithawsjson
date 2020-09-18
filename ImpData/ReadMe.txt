Product REST API

1)Get List of All Products - http://localhost:8080/api/product  --> Method => GET
2)Save a Product - http://localhost:8080/api/product --> Method => POST
Request Body format -
{ 
  "product_id":4727,
  "subcategory":"mobile",
  "title":"Celkon Millennium Glory Q5",
  "price":4499,
  "popularity":1013
}

3)Load All JSON Data to MYSQL DataBase from Given URL
http://localhost:8080/api/load , METHOD => GET

4)http://localhost:8080/api/product/title/{title}
Search By Title


SQL Query -----

create database products;

use products;


create table tbl_products
(
product_id int primary key ,

subcategory varchar (50) not null,

title varchar(100) not null,

price bigint ,

popularity bigint
);



select * from tbl_products;

select * from tbl_products where title = 'Micromax Gamolution G4' OR title = 'Nokia C5';

SELECT Count(*) FROM tbl_products WHERE title LIKE '%iphone%' ;


drop table tbl_products;