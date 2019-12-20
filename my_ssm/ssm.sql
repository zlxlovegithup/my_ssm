-- ��Ʒ��
CREATE TABLE product(
  id varchar2(32) default SYS_GUID() PRIMARY KEY, -- �����壬����uuid
  productNum VARCHAR2(50) NOT NULL,               -- ��Ʒ���,Ψһ,��Ϊ��
  productName VARCHAR2(50),                       -- ��Ʒ����
  cityName VARCHAR2(50),                          -- ��������
  DepartureTime timestamp,                        -- ����ʱ��
  productPrice Number,                            -- ��Ʒ�۸�
  productDesc VARCHAR2(500),                      -- ��Ʒ����
  productStatus INT,                              -- ״̬ (0 �ر� 1 ����)
  CONSTRAINT product UNIQUE (id,productNum)
)
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-002','����������','����',to_timestamp('20-5-2019 10:10:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),1200,'������������',1);
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-003','����������','����',to_timestamp('20-6-2019 14:30:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),1800,'���ݣ�������',0);     
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-001','�Ϻ�������','�Ϻ�',to_timestamp('20-7-2019 04:30:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),2000,'�Ϻ���������',1);
       
select * from product;

-- �鿴��ǰ���ݿ�ı��뷽ʽ
select userenv('language') from dual;

-- ������
CREATE TABLE orders(
       id varchar2(32) default SYS_GUID() PRIMARY KEY, -- ������:����uuid
       orderNum VARCHAR2(20) not null unique,          -- ������ţ���Ϊ�գ�Ψһ
       orderTime timestamp,                            -- �µ�ʱ��
       peopleCount INT,                                -- ��������
       orderDesc varchar2(500),                        -- ��������
       payType int,                                    -- ֧����ʽ(0 ֧���� 1 ΢�� 2 ����)
       orderStatus int,                                -- ����״̬ (0δ֧�� 1 ��֧��)
       productId varchar2(32),                         -- ��Ʒid���(��Ʒ��) �����˶������Ʒ֮��Ĺ�ϵ
       memberId varchar2(32),                          -- ��Ա(��ϵ��)id���  �����˶������Ա֮��Ĺ�ϵ
       foreign key (productId) references product(id),
       foreign key (memberId) references member(id)
)

insert into ORDERS (ordernum, ordertime, peoplecount, orderDesc, paytype, orderstatus, productid, memberid)
values ('12345', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'B2C465F60A40424DB87B69040A557C8E', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('54321', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'B2C465F60A40424DB87B69040A557C8E', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('67890', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('98765', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('11111', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('22222', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('33333', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, '8F80DC8E8AE2451FB219554222DA5B34', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('44444', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, '8F80DC8E8AE2451FB219554222DA5B34', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('55555', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'A79E67A2CDE740A6ADB2D68C481A0094', 'F1B805A75F40482795117F9984AF77CA');
 
select * from orders;
select count(*) from orders;


-- ��Ա��
create table member(
       id varchar2(32) default SYS_GUID() PRIMARY KEY,-- �����壬ϵͳ�Զ����ɣ�����ID
       name varchar2(20),                             -- ����
       nickname varchar2(20),                         -- �ǳ�
       phoneNum varchar2(20),                         -- �绰����
       email varchar2(20)                             -- ����
)

insert into member (name,nickname,phonenum,email)
values('����','���ն���','15870068311','3391773423@qq.com');

select * from member;
select count(*) from member;

-- �ÿͱ�
create table traveller(
       id varchar2(32) default SYS_GUID() primary key,-- ����uuid ������
       name varchar2(20),                           -- ����
       sex varchar2(20),                            -- �Ա�
       phoneNum varchar2(20),                       -- �绰����
       credentialsType int,                         --֤������(0���֤ 1���� 2 ����֤)
       credentialsNum varchar2(50),                 -- ֤������
       travellerType int                            -- �ÿ�����(��Ⱥ) 0���� 1��ͯ
)
insert into TRAVELLER (name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('����', '��', '13333333333', 0, '123456789009876543', 0);
insert into TRAVELLER (name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('��С��', '��', '15555555555', 0, '987654321123456789', 1);

select * from traveller;
select count(*) from traveller;
-- ��Ʒ��
CREATE TABLE product(
  id varchar2(32) default SYS_GUID() PRIMARY KEY, -- �����壬����uuid
  productNum VARCHAR2(50) NOT NULL,               -- ��Ʒ���,Ψһ,��Ϊ��
  productName VARCHAR2(50),                       -- ��Ʒ����
  cityName VARCHAR2(50),                          -- ��������
  DepartureTime timestamp,                        -- ����ʱ��
  productPrice Number,                            -- ��Ʒ�۸�
  productDesc VARCHAR2(500),                      -- ��Ʒ����
  productStatus INT,                              -- ״̬ (0 �ر� 1 ����)
  CONSTRAINT product UNIQUE (id,productNum)
)
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-002','����������','����',to_timestamp('20-5-2019 10:10:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),1200,'������������',1);
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-003','����������','����',to_timestamp('20-6-2019 14:30:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),1800,'���ݣ�������',0);     
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-001','�Ϻ�������','�Ϻ�',to_timestamp('20-7-2019 04:30:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),2000,'�Ϻ���������',1);
       
select * from product;

-- �鿴��ǰ���ݿ�ı��뷽ʽ
select userenv('language') from dual;

-- ������
CREATE TABLE orders(
       id varchar2(32) default SYS_GUID() PRIMARY KEY, -- ������:����uuid
       orderNum VARCHAR2(20) not null unique,          -- ������ţ���Ϊ�գ�Ψһ
       orderTime timestamp,                            -- �µ�ʱ��
       peopleCount INT,                                -- ��������
       orderDesc varchar2(500),                        -- ��������
       payType int,                                    -- ֧����ʽ(0 ֧���� 1 ΢�� 2 ����)
       orderStatus int,                                -- ����״̬ (0δ֧�� 1 ��֧��)
       productId varchar2(32),                         -- ��Ʒid���(��Ʒ��) �����˶������Ʒ֮��Ĺ�ϵ
       memberId varchar2(32),                          -- ��Ա(��ϵ��)id���  �����˶������Ա֮��Ĺ�ϵ
       foreign key (productId) references product(id),
       foreign key (memberId) references member(id)
)

insert into ORDERS (ordernum, ordertime, peoplecount, orderDesc, paytype, orderstatus, productid, memberid)
values ('12345', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'B2C465F60A40424DB87B69040A557C8E', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('54321', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'B2C465F60A40424DB87B69040A557C8E', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('67890', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('98765', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('11111', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('22222', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('33333', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, '8F80DC8E8AE2451FB219554222DA5B34', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('44444', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, '8F80DC8E8AE2451FB219554222DA5B34', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('55555', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, 'ûʲô', 0, 1, 'A79E67A2CDE740A6ADB2D68C481A0094', 'F1B805A75F40482795117F9984AF77CA');
 
select * from orders;
select count(*) from orders;


-- ��Ա��
create table member(
       id varchar2(32) default SYS_GUID() PRIMARY KEY,-- �����壬ϵͳ�Զ����ɣ�����ID
       name varchar2(20),                             -- ����
       nickname varchar2(20),                         -- �ǳ�
       phoneNum varchar2(20),                         -- �绰����
       email varchar2(20)                             -- ����
)

insert into member (name,nickname,phonenum,email)
values('����','���ն���','15870068311','3391773423@qq.com');

select * from member;
select count(*) from member;

-- �ÿͱ�
create table traveller(
       id varchar2(32) default SYS_GUID() primary key,-- ����uuid ������
       name varchar2(20),                           -- ����
       sex varchar2(20),                            -- �Ա�
       phoneNum varchar2(20),                       -- �绰����
       credentialsType int,                         --֤������(0���֤ 1���� 2 ����֤)
       credentialsNum varchar2(50),                 -- ֤������
       travellerType int                            -- �ÿ�����(��Ⱥ) 0���� 1��ͯ
)
insert into TRAVELLER (name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('����', '��', '13333333333', 0, '123456789009876543', 0);
insert into TRAVELLER (name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('��С��', '��', '15555555555', 0, '987654321123456789', 1);

select * from traveller;
select count(*) from traveller;

-- �����ÿͺͶ������м��
create table order_traveller(
       orderId varchar2(32),
       travellerId varchar2(32),
       primary key (orderId,travellerId),
       foreign key (orderId) references orders(id),
       foreign key (travellerId) references traveller(id)
)

insert into order_traveller
values('8CA38F1632F44A3F9021E23B9476C81B','5F32716AC2CA404094FC15DBD3E3AAF5');
insert into order_traveller
values('27A4343B15A446BAA1CBC12C75917222','5F32716AC2CA404094FC15DBD3E3AAF5');
insert into order_traveller
values('25EE2C72218D4DEEB150F7EA5173B883','2F935D0D34C441B199FEA4906A352E62');
insert into order_traveller
values('C78ED2EF9F9E4BD493D69B0A7EC67932','2F935D0D34C441B199FEA4906A352E62');
insert into order_traveller
values('0E0D28158E5A40B3B82ACCDEB413A51B','5F32716AC2CA404094FC15DBD3E3AAF5');
insert into order_traveller
values('D066E6D85BED4CE49784C43F0ACFEF73','2F935D0D34C441B199FEA4906A352E62');
insert into order_traveller
values('EE699165F2884C3398826685F99126D6','5F32716AC2CA404094FC15DBD3E3AAF5');
insert into order_traveller
values('4989D488ECB24DBF9BB081014CF2D117','2F935D0D34C441B199FEA4906A352E62');
insert into order_traveller
values('11C434854F934C0B8C6D4F03FBE64255','2F935D0D34C441B199FEA4906A352E62');

select * from traveller;
select * from orders;
select * from order_traveller;
select * from member;
select * from users;

-- �����û���
create table users(
       id varchar2(32) default SYS_GUID() primary key,-- UUID ������ ����UUID
       email varchar2(50) unique not null,            -- �ǿն���Ψһ
       username varchar2(50),                         -- �û���
       password varchar2(100),                        -- ������Ҫ��һ�㣬��Ϊ֮����ܵĻ��������ɺܳ����ַ���
       phoneNum varchar2(20),                         -- �绰����
       status int                                     -- ״̬(0 δ���� 1 �Ѿ�����)
)

insert into users(id,email,username,password,phoneNum,status) values('user_1','3371994757@qq.com','С���','zlx1234','13888866668','1');
delete from users where username='С���';
delete from users where username='С���';
update users set status = 1 where username='С���';
insert into users(email,username,password,phoneNum,status) values('3371994757@qq.com','����','zlx1234','13888866668','1')
update users set status = 0 where status = 1;
update users set status = 1 where status = 0;
select * from users;

-- ������ɫ��
create table role(
       id varchar2(32) default SYS_GUID() primary key, -- ������ ����UUID
       roleName varchar2(50),                          -- ��ɫ����
       roleDesc varchar2(50)                           -- ��ɫ����
)

insert into role(id,rolename,roledesc) values('role_admin','ADMIN','����Ա�û�');
insert into role(id,rolename,roledesc) values('role_user','USER','��ͨ�û�');
insert into role(id,rolename,roledesc) values('role_student','STUDENT','ѧ���û�');
insert into role(id,rolename,roledesc) values('role_teacher','TEACHER','��ʦ�û�');
delete from role where id='role_admin';
delete from role where  id='role_user';
select * from role;

-- �����û��ͽ�ɫ�Ĺ�����ϵ��
create table users_role(
       userId varchar2(32),                            -- ��� ��Ӧusers���е�id
       roleId varchar2(32),                            -- ��� ��Ӧrole���е�id
       primary key (userId,roleId),
       foreign key (userId) references users(id),
       foreign key (roleId) references role(id)
)
insert into users_role(userId,roleId) values('user_1','role_admin');
insert into users_role(userId,roleId) values('user_1','role_user');
delete from users_role where userId = 'user_1';
delete from users_role where userId = '8DD140F5830A4E309E00BD5231FA4A7F';
select * from users_role;

insert into users_role(userId,roleId) values('user_1','role_student');
insert into users_role(userId,roleId) values('user_1','role_teacher');

-- ����Ȩ�ޱ�
create table permission(
       id varchar2(32) default SYS_GUID() primary key,-- ������ ����UUID
       permissionName varchar2(50),                   -- Ȩ����
       url varchar2(100)                               -- ��Դ·��
)



select * from permission;

-- ������ɫ��Ȩ�޵Ĺ�ϵ��
create table role_permission(
       permissionId varchar2(32),                     -- ��� ��ӦȨ�ޱ��е�id
       roleId varchar2(32),                           -- ��� ��Ӧ��ɫ���е�id
       primary key (permissionId,roleId),
       foreign key(permissionId) references permission(id),
       foreign key (roleId) references role(id)
)
select * from role_permission;

-- ������־������Ϣ��
create table sysLog(
       id varchar2(32) default SYS_GUID() primary key, -- ������ UUID
       visitTime timestamp,                            -- ����ʱ��
       username varchar2(50),                          -- �������û���
       ip varchar2(30),                                -- ����IP
       url varchar2(50),                               -- ������ԴURL
       executionTime int,                              -- ִ��ʱ��
       method varchar2(200)                            -- ���ʷ���
)
select * from sysLog;


       
       
       
       
















       
       
       
       
