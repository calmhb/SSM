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

--订单条目表
create table t_order_item(
  id int unsigned auto_increment primary key,
  p_id int unsigned,
  qty int ,#商品的数量
  o_id int unsigned,#该订单条目隶属的订单
  #设置外键
  constraint t_orderitem_oid_fk foreign key(o_id)
  references t_order(id),
  constraint t_orderitem_pid_fk foreign key(p_id)
  references t_product(id)
)engine=InnoDB default charset=utf8;


/*商品表*/
create table t_product(
  id int unsigned auto_increment primary key,
  name varchar(60) not null,
  `desc` varchar(1000) not null,
  pic varchar(60),
  account int,
  price double(7,2) not null
)engine=InnoDB default charset=utf8;

insert into t_product values
(default,'iphone7s','手机真不错!','iphone4s.jpg',1000,3400.00),
(default,'三星i9100','巨坑!','i9100g.jpg',200,400.00),
(default,'锤子','情怀..!','ME525.jpg',1000,3400.00),
(default,'小米5s','可以飞了!','MI-ONE.jpg',2000,1400.00),
(default,'小辣椒','真名字不错!','S58.jpg',100,200.00),
(default,'格力手机','奇葩中战斗机!','T328d.jpg',3000,600.00);


/*插入语句*/
insert into t_user(name,pwd) values('haoren',md5('250'));





   



