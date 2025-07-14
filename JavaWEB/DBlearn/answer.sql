create table user(
    id int primary key auto_increment comment 'ID 唯一标识',
    create_time DATETIME comment '创建时间',
    update_time DATETIME comment '修改时间',
    username varchar(50) not null unique comment '用户名',
    name varchar(10) not null comment '姓名',
    age int comment '年龄',
    gender tinyint unsigned not null default 1 comment '性别',
    job tinyint unsigned comment '职位',
    phone char(11) unique not null comment '手机号',
    price int unsigned comment '薪资',
    jointime date comment '入职日期',
    image_path varchar(255) comment '头像路径',
    password varchar(32) default '123456' comment '密码'
) comment '用户信息表';

show tables ;

desc userlist;

show create table user;

alter table user add qq varchar(13) unique comment 'QQ';

alter table user modify qq varchar(15) comment 'QQ';

alter table user change qq qq_num varchar(15) comment 'QQ';

alter table user drop column qq_num;

alter table user rename to userlist;

drop table user;

insert into userlist (id,username,name,gender,phone) values (1,'TWstak','sanshui',1,'19327801120');

insert into userlist values (null,now(),now(),'Sicrin','FEI','18',0,null,'11122233344',null,'2020-01-01',null,default);

update userlist set username = 'TW',name = 'QIN' where id=1;

update userlist set jointime = '2020-01-02';

delete from userlist where username = 'Sicrin';

create table emp(
    id int unsigned primary key auto_increment comment 'ID,主键',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) not null comment '密码',
    name varchar(10) not null comment '姓名',
    gender tinyint unsigned not null comment '性别, 1:男, 2:女',
    phone char(11) not null unique comment '手机号',
    job tinyint unsigned comment '职位, 1:班主任,2:讲师,3:学工主管,4:教研主管,5:咨询师',
    salary int unsigned comment '薪资',
    image varchar(255) comment '头像',
    entry_date date comment '入职日期',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间'
) comment '员工表';

INSERT INTO emp(id, username, password, name, gender, phone, job, salary, image, entry_date, create_time, update_time)
VALUES (1,'shinaian','123456','施耐庵',1,'13309090001',4,15000,'1.jpg','2000-01-01','2024-04-11 16:35:33','2024-04-11 16:35:35'),
     (2,'songjiang','123456','宋江',1,'13309090002',2,8600,'2.jpg','2015-01-01','2024-04-11 16:35:33','2024-04-11 16:35:37'),
     (3,'lujunyi','123456','卢俊义',1,'13309090003',2,8900,'3.jpg','2008-05-01','2024-04-11 16:35:33','2024-04-11 16:35:39'),
     (4,'wuyong','123456','吴用',1,'13309090004',2,9200,'4.jpg','2007-01-01','2024-04-11 16:35:33','2024-04-11 16:35:41'),
     (5,'gongsunsheng','123456','公孙胜',1,'13309090005',2,9500,'5.jpg','2012-12-05','2024-04-11 16:35:33','2024-04-11 16:35:43'),
     (6,'huosanniang','123456','扈三娘',2,'13309090006',3,6500,'6.jpg','2013-09-05','2024-04-11 16:35:33','2024-04-11 16:35:45'),
     (7,'chaijin','123456','柴进',1,'13309090007',1,4700,'7.jpg','2005-08-01','2024-04-11 16:35:33','2024-04-11 16:35:47'),
     (8,'likui','123456','李逵',1,'13309090008',1,4800,'8.jpg','2014-11-09','2024-04-11 16:35:33','2024-04-11 16:35:49'),
     (9,'wusong','123456','武松',1,'13309090009',1,4900,'9.jpg','2011-03-11','2024-04-11 16:35:33','2024-04-11 16:35:51'),
     (10,'lichong','123456','林冲',1,'13309090010',1,5000,'10.jpg','2013-09-05','2024-04-11 16:35:33','2024-04-11 16:35:53'),
     (11,'huyanzhuo','123456','呼延灼',1,'13309090011',2,9700,'11.jpg','2007-02-01','2024-04-11 16:35:33','2024-04-11 16:35:55'),
     (12,'xiaoliguang','123456','小李广',1,'13309090012',2,10000,'12.jpg','2008-08-18','2024-04-11 16:35:33','2024-04-11 16:35:57'),
     (13,'yangzhi','123456','杨志',1,'13309090013',1,5300,'13.jpg','2012-11-01','2024-04-11 16:35:33','2024-04-11 16:35:59'),
     (14,'shijin','123456','史进',1,'13309090014',2,10600,'14.jpg','2002-08-01','2024-04-11 16:35:33','2024-04-11 16:36:01'),
     (15,'sunerniang','123456','孙二娘',2,'13309090015',2,10900,'15.jpg','2011-05-01','2024-04-11 16:35:33','2024-04-11 16:36:03'),
     (16,'luzhishen','123456','鲁智深',1,'13309090016',2,9600,'16.jpg','2010-01-01','2024-04-11 16:35:33','2024-04-11 16:36:05'),
     (17,'liying','12345678','李应',1,'13309090017',1,5800,'17.jpg','2015-03-21','2024-04-11 16:35:33','2024-04-11 16:36:07'),
     (18,'shiqian','123456','时迁',1,'13309090018',2,10200,'18.jpg','2015-01-01','2024-04-11 16:35:33','2024-04-11 16:36:09'),
     (19,'gudasao','123456','顾大嫂',2,'13309090019',2,10500,'19.jpg','2008-01-01','2024-04-11 16:35:33','2024-04-11 16:36:11'),
     (20,'ruanxiaoer','123456','阮小二',1,'13309090020',2,10800,'20.jpg','2018-01-01','2024-04-11 16:35:33','2024-04-11 16:36:13'),
     (21,'ruanxiaowu','123456','阮小五',1,'13309090021',5,5200,'21.jpg','2015-01-01','2024-04-11 16:35:33','2024-04-11 16:36:15'),
     (22,'ruanxiaoqi','123456','阮小七',1,'13309090022',5,5500,'22.jpg','2016-01-01','2024-04-11 16:35:33','2024-04-11 16:36:17'),
     (23,'ruanji','123456','阮籍',1,'13309090023',5,5800,'23.jpg','2012-01-01','2024-04-11 16:35:33','2024-04-11 16:36:19'),
     (24,'tongwei','123456','童威',1,'13309090024',5,5000,'24.jpg','2006-01-01','2024-04-11 16:35:33','2024-04-11 16:36:21'),
     (25,'tongmeng','123456','童猛',1,'13309090025',5,4800,'25.jpg','2002-01-01','2024-04-11 16:35:33','2024-04-11 16:36:23'),
     (26,'yanshun','123456','燕顺',1,'13309090026',5,5400,'26.jpg','2011-01-01','2024-04-11 16:35:33','2024-04-11 16:36:25'),
     (27,'lijun','123456','李俊',1,'13309090027',5,6600,'27.jpg','2004-01-01','2024-04-11 16:35:33','2024-04-11 16:36:27'),
     (28,'lizhong','123456','李忠',1,'13309090028',5,5000,'28.jpg','2007-01-01','2024-04-11 16:35:33','2024-04-11 16:36:29'),
     (29,'songqing','123456','宋清',1,'13309090029',5,5100,'29.jpg','2020-01-01','2024-04-11 16:35:33','2024-04-11 16:36:31'),
     (30,'liyun','123456','李云',1,'13309090030',NULL,NULL,'30.jpg','2020-03-01','2024-04-11 16:35:33','2024-04-11 16:36:31');



--  =================== DQL: 基本查询 ======================
-- 1. 查询指定字段 name,entry_date 并返回

    select name,emp.entry_date from emp;

-- 2. 查询返回所有字段

    select * from emp;

-- 3. 查询所有员工的 name,entry_date, 并起别名(姓名、入职日期)

    select name 姓名 ,emp.entry_date 入职日期 from emp;

-- 4. 查询已有的员工关联了哪几种职位(不要重复)

    select distinct job from emp;

--  =================== DQL: 条件查询 ======================
-- 1. 查询 姓名 为 柴进 的员工

    select * from emp where name='柴进';

-- 2. 查询 薪资小于等于5000 的员工信息

    select * from emp where salary<=5000

-- 3. 查询 没有分配职位 的员工信息

    select * from emp where job is null ;

-- 4. 查询 有职位 的员工信息

    select * from emp where job is not null ;

-- 5. 查询 密码不等于 '123456' 的员工信息

    select * from emp where password!='123456';

-- 6. 查询 入职日期 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间的员工信息

    select * from emp where entry_date between '2000-01-01' and '2005-01-01';

-- 7. 查询 入职时间 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间 且 性别为女 的员工信息

    select * from emp where entry_date between '2000-01-01' and '2010-01-01' and gender=2;

-- 8. 查询 职位是 2 (讲师), 3 (学工主管), 4 (教研主管) 的员工信息

    select * from emp where job in(2,3,4);

-- 9. 查询 姓名 为两个字的员工信息

    select * from emp where name like '__';

-- 10. 查询 姓 '李' 的员工信息

    select * from emp where name like '阮%';

-- 11. 查询 姓名中包含 '二' 的员工信息

    select * from emp where name like '%二%';

--  =================== DQL: 分组查询 ======================
-- 聚合函数

-- 1. 统计该企业员工数量 - count
select count(id) from emp;
select count(job) from emp;
select count(*) from emp;
select count(1) from emp;
-- 2. 统计该企业员工的平均薪资

select avg(emp.salary) from emp;

-- 3. 统计该企业员工的最低薪资
select min(emp.salary) from emp;

-- 4. 统计该企业员工的最高薪资

select max(emp.salary) from emp;
-- 5. 统计该企业每月要给员工发放的薪资总额(薪资之和)
select sum(emp.salary) from emp;




-- 分组
-- 1. 根据性别分组 , 统计男性和女性员工的数量

    select gender,count(*) from emp group by gender ;

-- 2. 先查询入职时间在 '2015-01-01' (包含) 以前的员工 , 并对结果根据职位分组 , 获取员工数量大于等于2的职位
    select job from emp where entry_date<='2015-01-01' group by job having count(*)>=2;

--  =================== 排序查询 ======================
-- 1. 根据入职时间, 对员工进行升序排序

    select * from emp order by entry_date asc ;

-- 2. 根据入职时间, 对员工进行降序排序

    select * from emp order by entry_date desc;

-- 3. 根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 更新时间 进行降序排序

    select * from emp order by entry_date asc , update_time desc ;

--  =================== 分页查询 ======================
-- 1. 从起始索引0开始查询员工数据, 每页展示5条记录

    SELECT * FROM emp LIMIT 0,5;

-- 2. 查询 第1页 员工数据, 每页展示5条记录

     SELECT * FROM emp LIMIT 5,5;

-- 3. 查询 第2页 员工数据, 每页展示5条记录

    SELECT * FROM emp LIMIT 10,5;

-- 4. 查询 第3页 员工数据, 每页展示5条记录

    SELECT * FROM emp LIMIT 15,5;

