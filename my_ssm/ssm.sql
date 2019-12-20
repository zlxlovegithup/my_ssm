-- 产品表
CREATE TABLE product(
  id varchar2(32) default SYS_GUID() PRIMARY KEY, -- 无意义，主键uuid
  productNum VARCHAR2(50) NOT NULL,               -- 产品编号,唯一,不为空
  productName VARCHAR2(50),                       -- 产品名称
  cityName VARCHAR2(50),                          -- 出发城市
  DepartureTime timestamp,                        -- 出发时间
  productPrice Number,                            -- 产品价格
  productDesc VARCHAR2(500),                      -- 产品描述
  productStatus INT,                              -- 状态 (0 关闭 1 开启)
  CONSTRAINT product UNIQUE (id,productNum)
)
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-002','北京三日游','北京',to_timestamp('20-5-2019 10:10:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),1200,'北京，我来了',1);
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-003','广州三日游','广州',to_timestamp('20-6-2019 14:30:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),1800,'广州，我来了',0);     
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-001','上海三日游','上海',to_timestamp('20-7-2019 04:30:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),2000,'上海，我来了',1);
       
select * from product;

-- 查看当前数据库的编码方式
select userenv('language') from dual;

-- 订单表
CREATE TABLE orders(
       id varchar2(32) default SYS_GUID() PRIMARY KEY, -- 无意义:主键uuid
       orderNum VARCHAR2(20) not null unique,          -- 订单编号，不为空，唯一
       orderTime timestamp,                            -- 下单时间
       peopleCount INT,                                -- 出行人数
       orderDesc varchar2(500),                        -- 订单描述
       payType int,                                    -- 支付方式(0 支付宝 1 微信 2 其他)
       orderStatus int,                                -- 订单状态 (0未支付 1 已支付)
       productId varchar2(32),                         -- 产品id外键(产品表) 描述了订单与产品之间的关系
       memberId varchar2(32),                          -- 会员(联系人)id外键  描述了订单与会员之间的关系
       foreign key (productId) references product(id),
       foreign key (memberId) references member(id)
)

insert into ORDERS (ordernum, ordertime, peoplecount, orderDesc, paytype, orderstatus, productid, memberid)
values ('12345', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'B2C465F60A40424DB87B69040A557C8E', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('54321', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'B2C465F60A40424DB87B69040A557C8E', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('67890', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('98765', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('11111', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('22222', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('33333', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '8F80DC8E8AE2451FB219554222DA5B34', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('44444', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '8F80DC8E8AE2451FB219554222DA5B34', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('55555', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'A79E67A2CDE740A6ADB2D68C481A0094', 'F1B805A75F40482795117F9984AF77CA');
 
select * from orders;
select count(*) from orders;


-- 会员表
create table member(
       id varchar2(32) default SYS_GUID() PRIMARY KEY,-- 无意义，系统自动生成，主键ID
       name varchar2(20),                             -- 姓名
       nickname varchar2(20),                         -- 昵称
       phoneNum varchar2(20),                         -- 电话号码
       email varchar2(20)                             -- 邮箱
)

insert into member (name,nickname,phonenum,email)
values('张洋','旭日东升','15870068311','3391773423@qq.com');

select * from member;
select count(*) from member;

-- 旅客表
create table traveller(
       id varchar2(32) default SYS_GUID() primary key,-- 主键uuid 无意义
       name varchar2(20),                           -- 姓名
       sex varchar2(20),                            -- 性别
       phoneNum varchar2(20),                       -- 电话号码
       credentialsType int,                         --证件类型(0身份证 1护照 2 军官证)
       credentialsNum varchar2(50),                 -- 证件号码
       travellerType int                            -- 旅客类型(人群) 0成人 1儿童
)
insert into TRAVELLER (name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('张龙', '男', '13333333333', 0, '123456789009876543', 0);
insert into TRAVELLER (name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('张小龙', '男', '15555555555', 0, '987654321123456789', 1);

select * from traveller;
select count(*) from traveller;
-- 产品表
CREATE TABLE product(
  id varchar2(32) default SYS_GUID() PRIMARY KEY, -- 无意义，主键uuid
  productNum VARCHAR2(50) NOT NULL,               -- 产品编号,唯一,不为空
  productName VARCHAR2(50),                       -- 产品名称
  cityName VARCHAR2(50),                          -- 出发城市
  DepartureTime timestamp,                        -- 出发时间
  productPrice Number,                            -- 产品价格
  productDesc VARCHAR2(500),                      -- 产品描述
  productStatus INT,                              -- 状态 (0 关闭 1 开启)
  CONSTRAINT product UNIQUE (id,productNum)
)
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-002','北京三日游','北京',to_timestamp('20-5-2019 10:10:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),1200,'北京，我来了',1);
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-003','广州三日游','广州',to_timestamp('20-6-2019 14:30:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),1800,'广州，我来了',0);     
insert into PRODUCT (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)
       values('itcast-001','上海三日游','上海',to_timestamp('20-7-2019 04:30:00.000000','dd-mm-yyyy hh24:mi:ss:ff'),2000,'上海，我来了',1);
       
select * from product;

-- 查看当前数据库的编码方式
select userenv('language') from dual;

-- 订单表
CREATE TABLE orders(
       id varchar2(32) default SYS_GUID() PRIMARY KEY, -- 无意义:主键uuid
       orderNum VARCHAR2(20) not null unique,          -- 订单编号，不为空，唯一
       orderTime timestamp,                            -- 下单时间
       peopleCount INT,                                -- 出行人数
       orderDesc varchar2(500),                        -- 订单描述
       payType int,                                    -- 支付方式(0 支付宝 1 微信 2 其他)
       orderStatus int,                                -- 订单状态 (0未支付 1 已支付)
       productId varchar2(32),                         -- 产品id外键(产品表) 描述了订单与产品之间的关系
       memberId varchar2(32),                          -- 会员(联系人)id外键  描述了订单与会员之间的关系
       foreign key (productId) references product(id),
       foreign key (memberId) references member(id)
)

insert into ORDERS (ordernum, ordertime, peoplecount, orderDesc, paytype, orderstatus, productid, memberid)
values ('12345', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'B2C465F60A40424DB87B69040A557C8E', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('54321', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'B2C465F60A40424DB87B69040A557C8E', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('67890', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('98765', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('11111', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('22222', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'F509DEEF5E214FF385C2DAC95C699926', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('33333', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '8F80DC8E8AE2451FB219554222DA5B34', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('44444', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '8F80DC8E8AE2451FB219554222DA5B34', 'F1B805A75F40482795117F9984AF77CA');
insert into ORDERS (ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('55555', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, 'A79E67A2CDE740A6ADB2D68C481A0094', 'F1B805A75F40482795117F9984AF77CA');
 
select * from orders;
select count(*) from orders;


-- 会员表
create table member(
       id varchar2(32) default SYS_GUID() PRIMARY KEY,-- 无意义，系统自动生成，主键ID
       name varchar2(20),                             -- 姓名
       nickname varchar2(20),                         -- 昵称
       phoneNum varchar2(20),                         -- 电话号码
       email varchar2(20)                             -- 邮箱
)

insert into member (name,nickname,phonenum,email)
values('张洋','旭日东升','15870068311','3391773423@qq.com');

select * from member;
select count(*) from member;

-- 旅客表
create table traveller(
       id varchar2(32) default SYS_GUID() primary key,-- 主键uuid 无意义
       name varchar2(20),                           -- 姓名
       sex varchar2(20),                            -- 性别
       phoneNum varchar2(20),                       -- 电话号码
       credentialsType int,                         --证件类型(0身份证 1护照 2 军官证)
       credentialsNum varchar2(50),                 -- 证件号码
       travellerType int                            -- 旅客类型(人群) 0成人 1儿童
)
insert into TRAVELLER (name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('张龙', '男', '13333333333', 0, '123456789009876543', 0);
insert into TRAVELLER (name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('张小龙', '男', '15555555555', 0, '987654321123456789', 1);

select * from traveller;
select count(*) from traveller;

-- 创建旅客和订单的中间表
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

-- 创建用户表
create table users(
       id varchar2(32) default SYS_GUID() primary key,-- UUID 无意义 主键UUID
       email varchar2(50) unique not null,            -- 非空而且唯一
       username varchar2(50),                         -- 用户名
       password varchar2(100),                        -- 密码需要长一点，因为之后加密的话，会生成很长的字符串
       phoneNum varchar2(20),                         -- 电话号码
       status int                                     -- 状态(0 未开启 1 已经开启)
)

insert into users(id,email,username,password,phoneNum,status) values('user_1','3371994757@qq.com','小哥哥','zlx1234','13888866668','1');
delete from users where username='小哥哥';
delete from users where username='小姐姐';
update users set status = 1 where username='小哥哥';
insert into users(email,username,password,phoneNum,status) values('3371994757@qq.com','张三','zlx1234','13888866668','1')
update users set status = 0 where status = 1;
update users set status = 1 where status = 0;
select * from users;

-- 创建角色表
create table role(
       id varchar2(32) default SYS_GUID() primary key, -- 无意义 主键UUID
       roleName varchar2(50),                          -- 角色名称
       roleDesc varchar2(50)                           -- 角色描述
)

insert into role(id,rolename,roledesc) values('role_admin','ADMIN','管理员用户');
insert into role(id,rolename,roledesc) values('role_user','USER','普通用户');
insert into role(id,rolename,roledesc) values('role_student','STUDENT','学生用户');
insert into role(id,rolename,roledesc) values('role_teacher','TEACHER','教师用户');
delete from role where id='role_admin';
delete from role where  id='role_user';
select * from role;

-- 创建用户和角色的关联关系表
create table users_role(
       userId varchar2(32),                            -- 外键 对应users表中的id
       roleId varchar2(32),                            -- 外键 对应role表中的id
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

-- 创建权限表
create table permission(
       id varchar2(32) default SYS_GUID() primary key,-- 无意义 主键UUID
       permissionName varchar2(50),                   -- 权限名
       url varchar2(100)                               -- 资源路径
)



select * from permission;

-- 创建角色和权限的关系表
create table role_permission(
       permissionId varchar2(32),                     -- 外键 对应权限表中的id
       roleId varchar2(32),                           -- 外键 对应角色表中的id
       primary key (permissionId,roleId),
       foreign key(permissionId) references permission(id),
       foreign key (roleId) references role(id)
)
select * from role_permission;

-- 创建日志描述信息表
create table sysLog(
       id varchar2(32) default SYS_GUID() primary key, -- 无意义 UUID
       visitTime timestamp,                            -- 访问时间
       username varchar2(50),                          -- 操作者用户名
       ip varchar2(30),                                -- 访问IP
       url varchar2(50),                               -- 访问资源URL
       executionTime int,                              -- 执行时长
       method varchar2(200)                            -- 访问方法
)
select * from sysLog;


       
       
       
       
















       
       
       
       
