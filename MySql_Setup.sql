-- login with root to create user, DB and table and provide grants
 
create user 't'@'localhost' identified by 'avd';

grant all on *.* to 't'@'localhost' identified by 'avd';

create database book_store;

use book_store;

 CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  firstname varchar(60) NOT NULL,
  lastname varchar(60) NOT NULL,
  email varchar(60) NOT NULL,
  login varchar(60) NOT NULL,
  password varchar(60) NOT NULL,
  confirmPassword varchar(60) NOT NULL,
  account varchar(60),
  enabled tinyint(4) NOT NULL DEFAULT '1',
  birthdate Date,
  country varchar(60),
  city varchar(60),
  street varchar(60),
  account varchar(60),
  telephone varchar(60),
  comment varchar(400),
  PRIMARY KEY (id)
);
