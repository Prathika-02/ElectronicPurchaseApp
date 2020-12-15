DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  identifier VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  phone VARCHAR(250) NOT NULL 
);

INSERT INTO customer (id,identifier, name,email ,phone) VALUES ('1','101','Prathika','prathika@gmail.com','9247847122');
INSERT INTO customer (id,identifier, name,email ,phone) VALUES ('2','102','Radha','radha@gmail.com','7660881766');
INSERT INTO customer (id,identifier, name,email ,phone) VALUES ('3','103','Teena','teena@gmail.com','9246530559');
