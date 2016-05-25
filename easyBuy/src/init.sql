--用户表
create table cl_user(
 id number primary key,/*用户编号:主键*/
 username varchar2(30) not null,/*用户名*/
 pwd   varchar2(32) not null,/*密码*/
 pro   number default 0 
 /*描述权限:0表示普通用户 1表示管理员*/
);

--商品表
create table cl_product(
 id number primary key,
 pname varchar2(200) not null,/*商品名称*/
 price number(7,2),/*商品价格*/
 pic varchar2(200),/*商品图片:保存图片的路径*/
 numb number, /*库存量*/
 info varchar2(2000) /*商品描述*/
);
/*
 关系型数据库中:表之间的关系通过外键描述
 用户表和订单表的关系: 1:*
  |-1个用户可以有多个订单
  |-1个订单只能对应一个用户

 */
--订单表
create table cl_order(
 id number primary key ,
 account number(7,2) not null,/*总金额*/
 total number not null,/*货品总数*/
 dotime date default sysdate,/*下单时间*/
 u_id number references cl_user(id) /*外键*/
);

--订单详细表
create table cl_order_item(
 id number primary key,
 /*参照商品表*/
 p_id number references cl_product(id),
 numb number, /*商品的数量*/
 /*参照订单表 :订单表和订单条目表的关系:1:* */
 o_id number references cl_order(id),
 account number(7,2) /*小计金额*/
);

--定义控制主键的序列 sequence
create sequence cl_user_seq start with 1001;
create sequence cl_product_seq start with 8001;
create sequence cl_order_seq start with 1;
create sequence cl_order_item_seq start with 1;

--向商品表中追加数据
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'iphone6',6000,'土豪专用','iphone4s.jpg',100)
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'iphone5s',4000,'贷款买','iphone4s.jpg',100);
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'米4',3000,'很多人买','ME525.jpg',100);
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'垂子',2000,'极少人买','S58.jpg',100);
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'小辣椒',1500,'极品专用','T328d.jpg',100); 
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'三星6s',6500,'应用很多没用','i9100g.jpg',100);
