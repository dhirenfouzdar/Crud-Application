/*struts@crudopp database schema */
DROP DATABASE IF EXISTS Struts2CrudOpDB;
CREATE DATABASE Struts2CrudOpDB;
USE Struts2CrudOpDB;


DROP TABLE IF EXISTS `PersonEntity`;
create table `PersonEntity`(
`id` int not null AUTO_INCREMENT,
`name` varchar(12) not null,
`emailId` varchar(64) not null,
`mobile` varchar(64) not null,
`createdDate` dateTime,
`modifiedDate` dateTime,
PRIMARY KEY(`name`),
unique key(`id`)

);

insert into PersonEntity(name,emailId,mobile,createdDate,modifiedDate)values('admin','admin@gmail.com','8197817874',now(),now());
