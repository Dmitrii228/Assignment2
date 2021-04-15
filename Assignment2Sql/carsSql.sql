-- run this file in as the "root" user, it will create a user called student and has a password of student
-- this will make marking MUCH easier for me, so please set this up
CREATE USER 'car'@'localhost' IDENTIFIED BY 'car';
GRANT ALL PRIVILEGES ON *.* TO 'car'@'localhost' WITH GRANT OPTION;

CREATE DATABASE Assignment2;
USE Assignment2;
DROP TABLE IF EXISTS cars;
CREATE TABLE cars(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	make VARCHAR(20),
    model VARCHAR(20),
    year int(5),
    mileage int(100),
    price double(100,2)
);
INSERT INTO cars (make, model, year, mileage, price) VALUES ('Toyota','Camry',2012, 72000, 14000);


select* from cars;