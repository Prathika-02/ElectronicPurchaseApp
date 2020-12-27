DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  identifier VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  phone VARCHAR(250) NOT NULL 
  addressLineOne VARCHAR(250) NOT NULL,
  addressLineTwo VARCHAR(250) NOT NULL,
  lState VARCHAR(250) NOT NULL,
  country VARCHAR(250) NOT NULL,
  postalCode VARCHAR(250) NOT NULL,
);

INSERT INTO customer (id,identifier, name,email ,phone,addressLineOne,addressLineTwo,city,lState,country,postalCode) VALUES ('1','101','Prathika','prathika@gmail.com','9247847122','HNO:10-5-112','Fathenagar','Hyderabad','Telangana','India','50018');
INSERT INTO customer (id,identifier, name,email ,phone,addressLineOne,addressLineTwo,city,lState,country,postalCode) VALUES ('2','102','Radha','radha@gmail.com','7660881766','HNO:103/A','Gandhi Bhavan','Mumbai','Maharashtra','India','40098');
INSERT INTO customer (id,identifier, name,email ,phone,addressLineOne,addressLineTwo,city,lState,country,postalCode) VALUES ('3','103','Teena','teena@gmail.com','9246530559''HNO:108/B','IDPL','Bangalore','Karnataka','India','50018');
