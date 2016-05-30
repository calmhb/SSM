drop table t_user;
CREATE TABLE t_user
(
  ID int unsigned auto_increment primary key , 
  NAME VARCHAR(50) unique, 
  PWD VARCHAR(50), 
  PHONE VARCHAR(50)
)engine=InnoDB default charset=utf8;

insert into t_user (name, pwd, phone) values 
('haoren', '250', '110'),
('Jerry', 'abc', '119'),
('Andy', '456', '112');