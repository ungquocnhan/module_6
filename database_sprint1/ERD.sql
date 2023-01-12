CREATE DATABASE project_sprint1;
USE project_sprint1;

CREATE TABLE `position`(
	id int primary key auto_increment,
    name varchar(50)
);

CREATE TABLE account_employee(
	username VARCHAR(50) primary key,
    password VARCHAR(50)
);

CREATE TABLE role_employee(
	id INT PRIMARY KEY AUTO_INCREMENT,
    role VARCHAR(50)
);

CREATE TABLE role_account_employee(
	id int,
    username VARCHAR(50),
    PRIMARY KEY (id, username),
    FOREIGN KEY (id) REFERENCES role_employee (id),
    FOREIGN KEY (username) REFERENCES account_employee (username)
);

CREATE TABLE employee(
	id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(10),
    name VARCHAR(50),
    date_of_birth VARCHAR(10),
    gender BIT,
    phone_number VARCHAR(10),
    email VARCHAR(50),
    address VARCHAR(50),
    flag BIT,
    position_id INT,
    username VARCHAR(50),
    FOREIGN KEY (position_id) REFERENCES `position` (id),
    FOREIGN KEY (username) REFERENCES account_employee (username)
);
