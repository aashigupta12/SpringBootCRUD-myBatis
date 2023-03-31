CREATE TABLE employee_details (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  phone_no int,
  email_id varchar(200),
  is_Active tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ;