--�û���
create table cl_user(
 id number primary key,/*�û����:����*/
 username varchar2(30) not null,/*�û���*/
 pwd   varchar2(32) not null,/*����*/
 pro   number default 0 
 /*����Ȩ��:0��ʾ��ͨ�û� 1��ʾ����Ա*/
);

--��Ʒ��
create table cl_product(
 id number primary key,
 pname varchar2(200) not null,/*��Ʒ����*/
 price number(7,2),/*��Ʒ�۸�*/
 pic varchar2(200),/*��ƷͼƬ:����ͼƬ��·��*/
 numb number, /*�����*/
 info varchar2(2000) /*��Ʒ����*/
);
/*
 ��ϵ�����ݿ���:��֮��Ĺ�ϵͨ���������
 �û���Ͷ�����Ĺ�ϵ: 1:*
  |-1���û������ж������
  |-1������ֻ�ܶ�Ӧһ���û�

 */
--������
create table cl_order(
 id number primary key ,
 account number(7,2) not null,/*�ܽ��*/
 total number not null,/*��Ʒ����*/
 dotime date default sysdate,/*�µ�ʱ��*/
 u_id number references cl_user(id) /*���*/
);

--������ϸ��
create table cl_order_item(
 id number primary key,
 /*������Ʒ��*/
 p_id number references cl_product(id),
 numb number, /*��Ʒ������*/
 /*���ն����� :������Ͷ�����Ŀ��Ĺ�ϵ:1:* */
 o_id number references cl_order(id),
 account number(7,2) /*С�ƽ��*/
);

--����������������� sequence
create sequence cl_user_seq start with 1001;
create sequence cl_product_seq start with 8001;
create sequence cl_order_seq start with 1;
create sequence cl_order_item_seq start with 1;

--����Ʒ����׷������
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'iphone6',6000,'����ר��','iphone4s.jpg',100)
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'iphone5s',4000,'������','iphone4s.jpg',100);
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'��4',3000,'�ܶ�����','ME525.jpg',100);
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'����',2000,'��������','S58.jpg',100);
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'С����',1500,'��Ʒר��','T328d.jpg',100); 
insert into cl_product(id,pname,price,info,pic,numb)
 values(cl_product_seq.nextval,'����6s',6500,'Ӧ�úܶ�û��','i9100g.jpg',100);
