create table t_user(
  id int unsigned auto_increment primary key,
  name varchar(30) unique,
  pwd char(32) not null,
  `power` enum('管理员','普通用户') default '普通用户'
)engine=InnoDB auto_increment=1001 default charset=utf8;


create table t_order(
  id int unsigned auto_increment primary key,
  u_id int unsigned,
  dotime timestamp default current_timestamp,
  account double(7,2),
  constraint t_order_uid_fk foreign key(u_id) references t_user(id) 
)engine=InnoDB auto_increment=101 default charset=utf8;

/*插入语句*/
insert into t_user(name,pwd) values('haoren',md5('250'));