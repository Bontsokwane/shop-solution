DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
    customer_id Long PRIMARY KEY,
    customer_first_name varchar(20),
    customer_last_name varchar(20),
    registration_date date,
    customer_type varchar(10)

);
INSERT INTO "customer" (customer_id,customer_first_name,customer_last_name,registration_date,customer_type)
                     VALUES(233434,'Tefo','Bontsokwane',NULL,NULL);