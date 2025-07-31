### 数据库

创建时间: 2025.7.12

数据库是一个有组织的数据集合，通常存储在计算机系统中。它们可以被用来存储、管理和检索数据。数据库的设计和实现涉及多个方面，包括数据模型、数据库管理系统（DBMS）、查询语言等。

#### MYSQL连接

- mysql初始化：`mysqld --initialize-insecure`
- 启动mysql服务：`mysqld -install`
- 连接mysql：`mysql -u用户名 -p密码 [-h主机名 -P端口号]`

#### 数据模型

- **关系型数据库（Relational Database）**：数据以表格形式存储，表与表之间通过外键关联。
- 特点：
  - 数据结构化，易于查询和管理。
  - 使用SQL（结构化查询语言）进行数据操作。

- 创建数据库：
  ```sql
  CREATE DATABASE 数据库名;
  ```

#### SQL语句

不区分大小写，但通常使用大写来书写SQL关键字。
mysql8 默认字符集为 `utf8mb4`：


- 分类
    |分类|全称|说明|
    |---|---|---|
    |DDL|Data Definition Language|用于定义数据库结构，如创建、修改、删除表等。|
    |DML|Data Manipulation Language|用于操作数据，如插入、更新、删除数据等。|
    |DQL|Data Query Language|用于查询数据，如SELECT语句。|
    |DCL|Data Control Language|用于控制访问权限，如GRANT、REVOKE等。|

- DDL
    - 数据库创建删除
        ```sql
        show databases; -- 显示所有数据库

        select database(); -- 显示当前数据库

        use 数据库名; -- 选择/切换数据库

        create database [if not exists] 数据库名 [default character set utf8mb4]; -- 创建数据库

        drop database [if exists] 数据库名; -- 删除数据库
        ```
    - 表的创建
        ```sql
        create table [if not exists] 表名 (
            列名1 数据类型 [约束] [comment '注释'],
            列名2 数据类型 [约束] [comment '注释'],
            ...
            [primary key (列名)]
        ) [engine=存储引擎] [charset=utf8mb4] [comment '注释']; -- 创建表
        ```
        - 约束：约束是对表中数据的限制条件，主要包括：
            - NOT NULL：列不能为空。
            - UNIQUE：列值唯一。
            - PRIMARY KEY：主键，唯一标识一行数据。
            - FOREIGN KEY：外键，引用其他表的主键。
            - DEFAULT：默认值。
            - AUTO_INCREMENT：自增，通常用于主键。
    - 数据类型
        - 整数类型：INT, TINYINT, SMALLINT, MEDIUMINT, BIGINT  

        |类型|大小|有符号范围|无符号范围|描述|备注|
        |---|---|---|---|---|---|
        |TINYINT|1字节|-128到127|0到255|小整数|通常用于状态标志|
        |SMALLINT|2字节|-32768到32767|0到65535|小整数|适用于小范围数据|
        |MEDIUMINT|3字节|-8388608到8388607|0到16777215|中等整数|适用于中等范围数据|
        |INT|4字节|-2147483648到2147483647|0到4294967295|标准整数|常用的整数类型|
        |BIGINT|8字节|-9223372036854775808到9223372036854775807|0到18446744073709551615|大整数|适用于大范围数据|

        - 浮点类型：FLOAT, DOUBLE, DECIMAL

        |类型|大小|描述|备注|
        |---|---|---|---|
        |FLOAT|4字节|单精度浮点数|float(5,2):表示总共5位数字，其中2位是小数|
        |DOUBLE|8字节|双精度浮点数|double(10,5):表示总共10位数字，其中5位是小数|
        |DECIMAL|可变|定点数，精度可指定|decimal(10,2):表示总共10位数字，其中2位是小数|
        - 字符串类型：CHAR, VARCHAR, TINYBLOB,TINYTEXT, BLOB, TEXT, MEDIUMBLOB, MEDIUMTEXT, LONGBLOB, LONGTEXT

        |类型|大小|描述|
        |---|---|---|
        |CHAR|固定长度，最大255字节|适用于长度固定的字符串|
        |VARCHAR|可变长度，最大65535字节|适用于长度不固定的字符串|
        |TINYBLOB|最大255字节|适用于小二进制数据|
        |TINYTEXT|最大255字节|适用于小文本数据|
        |BLOB|最大65535字节|适用于大二进制数据|
        |TEXT|最大65535字节|适用于大文本数据|
        |MEDIUMBLOB|最大16777215字节|适用于中等大小的二进制数据|
        |MEDIUMTEXT|最大16777215字节|适用于中等大小的文本数据|
        |LONGBLOB|最大4294967295字节|适用于非常大的二进制数据|
        |LONGTEXT|最大4294967295字节|适用于非常大的文本数据|
        - 日期时间类型：DATE, TIME, YEAR, DATETIME, TIMESTAMP

        |类型|大小|描述|
        |---|---|---|
        |DATE|3字节|日期，格式为YYYY-MM-DD|
        |TIME|3字节|时间，格式为HH:MM:SS|
        |YEAR|1字节|年份，格式为YYYY|
        |DATETIME|8字节|日期和时间，格式为YYYY-MM-DD HH:MM:SS|
        |TIMESTAMP|4字节|时间戳，表示自1970年1月1日以来的秒数|
    - 表的查询、修改、删除
        ```sql
        show tables; -- 显示当前数据库中的所有表

        desc 表名; -- 显示表的结构

        show create table 表名; -- 显示创建表的SQL语句

        alter table 表名 add 列名 数据类型 [约束] [comment '注释']; -- 添加列

        alter table 表名 modify 列名 新数据类型 [约束] [comment '注释']; -- 修改列数据类型或约束

        alter table 表名 change 列名 新列名 新数据类型 [约束] [comment '注释']; -- 修改列名和数据类型

        alter table 表名 drop column 列名; -- 删除列

        alter table 表名 rename to 新表名; -- 重命名表

        drop table [if exists] 表名; -- 删除表
        ```
- DML:对数据库中表的数据记录进行增删改操作。
    - 插入数据（INSERT）
        ```sql
        --指定字段添加数据
        insert into 表名 (列名1, 列名2, ...) values (值1, 值2, ...);

        -- 全部字段添加数据
        insert into 表名 values (值1, 值2, ...);
        
        -- 批量添加数据（指定字段）
        insert into 表名 (列名1, 列名2, ...) values (值1, 值2, ...), (值3, 值4, ...);
        
        -- 批量添加数据（全部字段）
        insert into 表名 values (值1, 值2, ...), (值3, 值4, ...);

        -- 获取当前时间函数
        now();
        ```
    - 更新数据（UPDATE）
        ```sql
        update 表名 set 列名1 = 新值1, 列名2 = 新值2, ... [where 条件];
        -- 如果不加where条件，则会更新表中所有记录
        ```
    - 删除数据（DELETE）
        ```sql
        delete from 表名 [where 条件];
        -- 如果不加where条件，则会删除表中所有记录
        ```
- DQL:对数据库中表的数据记录进行查询操作。
    ```sql
    select
        列名1, 列名2, ...
    from
        表1, 表2, ... -- 基本查询
    where
        条件1 and 条件2 and ... -- 条件查询
    group by
        列名1, 列名2, ... 
    having
        条件3 and 条件4 and ... -- 分组查询
    order by
        列名1 [asc|desc], 列名2 [asc|desc], ... -- 排序查询
    limit
        偏移量, 数量; -- 分页查询
    
    ```
    - 基本查询：从那几张表中查询返回那些列
        ```sql
        -- 查询多个字段
        select 列名1, 列名2, ... from 表名;

        -- 查询所有字段
        select * from 表名;

        -- 为查询字段起别名，as关键字可省略
        select 列名1 as 别名1, 列名2 as 别名2 from 表名;

        -- 去除重复记录
        select distinct 列名1, 列名2 from 表名;
        ```
    - 条件查询：
        ```sql
        select 列名1, 列名2 from 表名 where 条件;
        ```

        |运算符|功能|
        |---|---|
        |=|等于|
        |!=或<>|不等于|
        |>|大于|
        |<|小于|
        |>=|大于等于|
        |<=|小于等于|
        |like 占位符|模糊匹配（_匹配单个字符，%匹配多个字符）|
        |in(...)|匹配多个值|
        |between ... and ...|范围匹配闭区间|
        |is null|判断是否为null|
        |is not null|判断是否不为null|
        |and &&|与|
        |or  |或|
        |not !|非|
    
    - 分组查询：将查询结果按某些列进行分组
        ```sql
        select 列名1, count(*) from 表名 group by 列名1 having 条件;
        ```
        - 分组后select的列必须是分组列或聚合函数。
        - where having的区别：
            - where在分组前过滤数据，不能使用聚合函数。
            - having在分组后过滤数据，可以使用聚合函数。

        |函数|功能|
        |---|---|
        |count(*)|统计行数|
        |sum(列名)|求和|
        |avg(列名)|平均值|
        |max(列名)|最大值|
        |min(列名)|最小值|

    - 排序查询：对查询结果进行排序
        ```sql
        select 列名1, 列名2 from 表名 order by 列名1 [asc|desc], 列名2 [asc|desc];
        ```
    
    - 分页查询：限制查询结果的数量和偏移量
        ```sql
        select 列名1, 列名2 from 表名 limit 偏移量, 数量;
        ```
        - 说明：
            1. 偏移量从0开始，表示从第几条记录开始查询。
            2. 如果起始索引为0，可以省略不写。
            3. 分页查询是数据库的方言，MySQL支持`LIMIT`语法。

### 多表关系

#### 一对多
- 场景：一个部门可以有多个员工
在多的一方（员工表）中添加外键，指向一的一方（部门表）的主键。
```sql
alter table 员工表 add constraint fk_部门 foreign key (部门_id) references 部门表(id);
```
- 物理外键：使用`foreign key`约束来维护数据的完整性。
- 缺点：物理外键会增加数据库的复杂性和性能开销，尤其是在数据量较大时。适用于单节点数据库。容易发生死锁。
- 逻辑外键：在应用层维护外键关系，不使用数据库的外键约束。

#### 一对一
- 场景：一个用户只能有一个个人信息记录
- 多用于单表拆分，将一张表的基础字段和扩展字段分开存储。
- 实现：在任意一方添加外键，指向另一方的主键，并设置外键为`Unique`。
```sql
alter table 用户表 add constraint fk_个人信息 Unique foreign key (用户_id) references 个人信息表(id);
```

#### 多对多
- 场景：一个学生可以选修多门课程，一门课程可以被多个学生选修
- 实现：创建一个关联表（中间表），包含两边的主键作为外键。
```sql
create table 学生课程 (
    学生_id int,
    课程_id int,
    primary key (学生_id, 课程_id),
    foreign key (学生_id) references 学生表(id),
    foreign key (课程_id) references 课程表(id)
);
```

#### 多表查询
```sql
select
    a.列名1, b.列名2
from
    表1 a, 表2 b
where
    a.列名3 = b.列名4;
```

- 连接查询：
    - 内连接：交集查询
        - 隐式内连接
        ```sql
        select a.列名1, b.列名2
        from 表1 a, 表2 b
        where a.列名3 = b.列名4;
        ```
        - 显式内连接
        ```sql
        select a.列名1, b.列名2
        from 表1 a
        [inner] join 表2 b on a.列名3 = b.列名4
        ```
    - 外连接：差集查询
        - 左外连接：左表所有记录，右表匹配的记录
        ```sql
        select a.列名1, b.列名2
        from 表1 a
        left join 表2 b on a.列名3 = b.列名4
        ```
        - 右外连接：右表所有记录，左表匹配的记录
        ```sql
        select a.列名1, b.列名2
        from 表1 a
        right join 表2 b on a.列名3 = b.列名4
        ```
        - 全外连接：两边所有记录，匹配的记录合并
        ```sql
        select a.列名1, b.列名2
        from 表1 a
        full join 表2 b on a.列名3 = b.列名4
        ```
- 子查询：SQL语句嵌套在另一个SQL语句中
    1. 标量子查询：子查询返回结果为单个值
    ```sql
    select 列名1 from 表名 where 列名2 = (select 列名2 from 表名 where 条件);
    ```
    2. 列子查询：子查询返回结果为单列
    ```sql
    select 列名1 from 表名 where 列名2 in (select 列名2 from 表名 where 条件);
    ```
    3. 行子查询：子查询返回结果为单行
    ```sql
    select 列名1 from 表名 where (列名2, 列名3) = (select 列名2, 列名3 from 表名 where 条件);
    ```
    4. 表子查询：子查询返回结果为多行多列
    ```sql
    select 列名1 from 表名 where 列名2 in (select 列名2, 列名3 from 表名 where 条件);
    ```