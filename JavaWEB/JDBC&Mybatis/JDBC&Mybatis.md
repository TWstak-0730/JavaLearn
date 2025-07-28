### JDBC

创建时间：2025-7-15

JDBC（Java Database Connectivity）是Java语言中用于连接和操作数据库的API。它提供了一种标准的方式来执行SQL语句、获取结果集以及处理数据库事务。

#### JBDC入门程序

- 步骤：
    1. 创建一个MAVEN项目，引入依赖;准备user表。
    2. 加载驱动类。
        ```xml
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.0.33</version>
        </dependency>
        ```
    3. 编写代码操作数据库。
        ```java
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接
        String url = "jdbc:mysql://localhost:3306/db01";
        String username = "root";
        String password = "Qinwenbin2005.";
        Connection ct = DriverManager.getConnection(url,username,password);
        // 3.获取执行对象

        Statement st = ct.createStatement();

        // 4.执行SQL语句

        int i = st.executeUpdate("update user set name = '李四' where id = 1");
        System.out.println("受影响的行数：" + i);
        // 5.释放资源
        st.close();
        ct.close();
        
        ```
#### 执行DQL语句
```java
Class.forName("com.mysql.cj.jdbc.Driver");

String url = "jdbc:mysql://localhost:3306/db01";
String username = "root";
String password = "Qinwenbin2005.";

Connection ct = DriverManager.getConnection(url, username, password);

String sql = "select * from user where username = ? and password = ?";

PreparedStatement ps = ct.prepareStatement(sql);

ps.setString(1, "daqiao");
ps.setString(2, "123456");

ResultSet rs = ps.executeQuery();

while (rs.next()) {
            // 获取数据
    Integer id = rs.getInt("id");
    String username1 = rs.getString("username");
    String password1 = rs.getString("password");
    String name = rs.getString("name");
    Integer age = rs.getInt("age");

            // 创建User对象
    User user = new User(id, username1, password1, name, age);
    System.out.println(user);
}

rs.close();
ps.close();
ct.close();
```
#### 预编译语句
预编译语句（PreparedStatement）是JDBC中用于执行参数化SQL语句的一种方式。它可以提高性能并防止SQL注入攻击。


### Mybatis
Mybatis是一个流行的Java**持久层**框架，它**简化**了数据库操作，提供了更灵活的SQL映射功能。Mybatis允许开发者使用XML或注解来配置和映射原生信息，将接口方法调用转换为数据库操作。

#### Mybatis入门程序

- 准备工作：
    1. 创建一个SpringBoot项目，引入Mybatis依赖。
    2. 准备user表。
    3. 配置Mybatis（在application.yml中配置数据源和Mybatis相关属性）。
- 编写Mybatis程序：编写Mybatis的持久层接口，定义SQL。

#### 数据库连接池
数据库连接池是为了提高数据库访问性能而设计的一种技术。它通过维护一定数量的数据库连接，供应用程序重复使用，从而减少频繁创建和销毁连接的开销。

在Mybatis中，可以通过配置数据源来实现连接池。常用的连接池有HikariCP、Druid等。

#### 删除操作

```java
@Delete("delete from user where id = #{id}")
public Integer deleteUserById(Integer id);
```
- `#{}`与`${}`的区别：
  - `#{}`：使用预编译语句，防止SQL注入。
  - `${}`：直接将值拼接到SQL中，不进行预编译，可能导致SQL注入风险。

#### 插入操作
```java
@Insert("insert into user (username, password, name, age) values (#{username}, #{password}, #{name}, #{age})")
public Integer insertUser(User user);
```

#### 更新操作
```java
@Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
public Integer updateUser(User user);
```
#### 查询操作
```java
@Select("select * from user where id = #{id}")
public User selectUserById(Integer id);
@Select("select * from user where username = #{username} and password = #{password}")
public User selectUserByUsernameAndPassword(@Param("username") String username, @Param("
password") String password);
```

#### XML映射配置

在Mybatis中，除了使用注解来定义SQL语句外，还可以使用XML文件来进行SQL映射配置。XML映射文件通常位于`resources/mappers`目录下。

- 默认规则
    1. 映射文件名与Mapper接口名相同，且位于相同的包路径下。（同包同名）
    2. 映射文件的命名空间与Mapper接口的全限定名相同。
    3. 映射文件中的SQL语句ID与Mapper接口中的方法名

```java
@mapper
public interface UserMapper {
    public List<User> selectAllUsers();
}
```

```xml
<mapper namespace="com.example.mapper.UserMapper">
    <select id="selectAllUsers" resultType="com.example.model.User">
        SELECT * FROM user
    </select>
</mapper>
```

- 配置
    1. 在`application.yml`中配置Mybatis的映射文件位置。
    ```yaml
    mybatis:
      mapper-locations: classpath:mappers/*.xml
      type-aliases-package: com.example.model
    ```