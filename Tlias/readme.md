# Tlias智能学习辅助系统开发
## 准备工作
### 开发规范-开发模式
**前后端分离**  
- 前端：
    - 使用html、css、js、Vue等技术
    - 部署在nginx上
- 后端：
    - 使用Java、Spring Boot等技术
    - 使用MySQL作为数据库
    - 部署在tomcat上
- 前后端使用`api接口文档.md`中定义的规范进行交互
### 开发规范-Restful风格
Restful风格的API设计规范：
- 使用HTTP方法（GET、POST、PUT、DELETE）来表示操作类型
- 使用URL来表示资源
    <!-- 资源示例：/api/departments/{id} -->
    |Rest风格Url|请求方式|含义|
    |---|---|---|
    |`http://localhost:8080/users/1`|GET|查询id为1的用户|
    |`http://localhost:8080/users`|POST|创建新用户|
    |`http://localhost:8080/users/1`|PUT|更新id为1的用户|
    |`http://localhost:8080/users/1`|DELETE|删除id为1的用户|
### 工程搭建
#### 1. 创建Spring Boot项目，引入Web依赖、mybatis依赖、MySQL依赖、lombok等
#### 2. 创建数据库表dept，并在application.yml中配置数据库连接信息
```yml
spring:
  application:
    name: Tlias-Web-Management

  datasource:
    url: jdbc:mysql://localhost:3306/tlias
    username: root
    password: Qinwenbin2005.
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver

mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  mapper-locations: classpath:mapper/*.xml
```



#### 3. 准备基础代码结构，并引入实体类Dept及统一的响应结果封装类Result
## 需求
### 部门管理
#### 查询部门
1. 由于部门表数据量较小，直接查询所有部门信息。
2. 对查询结果进行排序，按最后操作时间降序排列。
>详情见`api接口文档.md`中的部门管理部分。
- 数据封装：
    - 实体类属性名 和 数据库表查询返回的字段名保持一致 mybatis会自动映射。
    - 如果不一致，可以使用`@Results`注解进行映射。
    ```java
    @Results({
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();
    ```
    - 驼峰命名法：mybatis会自动将数据库字段名转换为驼峰命名法的属性名。
    ```yml
    mybatis:
      configuration:
        map-underscore-to-camel-case: true
    ```
#### 删除部门
1. 通过部门ID删除部门。
```java
public Result delete(@RequestParam("id") Integer deptId) {//如果声明了@RequestParam，则必须传入参数否则会报错

        System.out.println("删除部门数据，id：" + deptId);
        deptService.delete(deptId);
        return Result.success();
    }
```

#### 新增部门
1. 接收前端传入的部门名称，创建新的部门。
```java
@PostMapping("/depts")
    public Result addDept(@RequestBody Dept dept) {
        System.out.println("添加部门数据，name：" + dept.getName());
        deptService.addDept(dept);
        return Result.success();
    }
```  
#### 更新部门
1. 数据回显
2. 接收前端传入的部门ID和名称，更新部门信息。
```java
@PutMapping("/depts")
    public Result updateDept(@RequestBody Dept dept) {
        System.out.println("修改部门数据，id"+dept.getId()+"name"+dept.getName());
        deptService.updateDept(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result findById(@PathVariable("id") Integer deptId) {//PathVariable注解用于获取URL中的变量值
        // 例如：/depts/1，deptId将会是1
        System.out.println("根据ID查询部门数据" + deptId);
        Dept dept = deptService.getInfo(deptId);
        return Result.success(dept);
    }
```
#### 日志管理
- 日志技术
    - JUL (Java Util Logging) 是JAVA SE自带的日志框架，简单易用，但功能较为基础。
    - Log4j 是Apache提供的日志框架，功能强大，支持多种日志级别和输出方式。
    - Logback 是Log4j的继承者，性能更好，配置更灵活。
    - SLF4J (Simple Logging Facade for Java) 是一个日志门面，提供统一的日志接口，可以与多种日志框架结合使用。
- logback快速入门
    - 准备工作：引入依赖（SpringBoot项目中该依赖已经传递）、配置logback.xml文件。
    ```xml
        <?xml version="1.0" encoding="UTF-8"?>
    <configuration>
        <!-- 控制台输出 -->
        <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
            <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
                <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度  %logger{50}: 最长50个字符(超出.切割)  %msg：日志消息，%n是换行符 -->
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
            </encoder>
        </appender>
        
        <!-- 日志输出级别 -->
        <root level="debug">
            <appender-ref ref="STDOUT" />
        </root>
    </configuration>
    ```
    - 记录日志：定义日志记录对象，记录日志。
    ```java
    public class LogTest {

    private static final Logger log = LoggerFactory.getLogger(LogTest.class);
    @Test
    public void testLog(){
        //System.out.println(LocalDateTime.now() + " : 开始计算...");
        log.debug("开始计算");
        int sum = 0;
        int[] nums = {1, 5, 3, 2, 1, 4, 5, 4, 6, 7, 4, 34, 2, 23};
        for (int num : nums) {
            sum += num;
        }
        log.info("计算结果为："+sum);
        //System.out.println("计算结果为: "+sum);
        //System.out.println(LocalDateTime.now() + "结束计算...");
        log.debug("结束计算");
    }

    }
    ```
- 日志级别  

|日志级别|说明|记录方式|
|---|---|---|
|TRACE|跟踪信息，最详细的日志级别|log.trace("跟踪信息")|
|DEBUG|调试信息，开发阶段使用 最低级|log.debug("调试信息")|
|INFO|普通信息，表示系统正常运行|log.info("普通信息")|
|WARN|警告信息，表示可能存在问题|log.warn("警告信息")|
|ERROR|错误信息，表示系统出现异常|log.error("错误信息")|
### 员工管理
- 查询所有员工信息，并查询出部门名称
- 准备数据库表emp,emp_expr实体类Emp,EmpExpr三层架构
- 可在Controller层类中使用`@RequestMapping("/emps")`代替`@GetMapping("/emps")`，这样可以将所有请求映射到该类中，方便管理。
- pageHelper分页插件
    - 引入依赖
    ```xml
    <dependency>
        <groupId>com.github.pagehelper</groupId>
        <artifactId>pagehelper-spring-boot-starter</artifactId>
        <version>1.4.2</version>
    </dependency>
    ```
    - 在Service层中使用PageHelper进行分页查询
    ```java
        public PageResult<Emp> getEmpList(Integer page, Integer pageSize) {
            PageHelper.startPage(page, pageSize);
            Page<Emp> p = (Page<Emp>) empMapper.getEmpList();
            return new PageResult<Emp>(p.getTotal(),p.getResult());
        }
    ```
    - `PageHelper`实现机制
        在调用`Mapper`中对应的查询方法时自动拦截`SQL`语句，并在执行前进行分页参数的设置。
    - 注意：
        1. 在使用`PageHelper`时，不能再语句中加`;`，否则会导致`SQL`语句错误。
        2. 在使用`PageHelper`时，只会在设置`startPage`后的第一条SQL语句生效。
- 条件查询
    - 使用xml配置Select语句
        1. 在resource目录下创建与mapper同包同名的文件夹，并在其中创建EmpMapper.xml文件。
        ```xml
                <?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE mapper
                PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
                "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
        <mapper namespace="xyz.twstak.tliaswebmanagement.mapper.EmpMapper">
            <select id="getEmpList" resultType="xyz.twstak.tliaswebmanagement.pojo.Emp">
                SELECT e.*,d.name from emp e
                    left join dept d on e.dept_id = d.id
                                where (e.name like '%阮%' || e.name is null ) and
                                        (e.gender = 1||e.gender is null ) and
                                        ((e.entry_date between '2000-01-01' and '2099-12-31')||e.entry_date is null)
                                order by e.update_time desc
            </select>
        </mapper>
        ```
        resultType属性指定返回结果的类型是返回结果列表的单条数据对应的数据类型。
        ```xml
        <where>
            <if test="name != null and name != ''">
                (e.name like concat('%',#{name},'%'))
            </if>
            <if test="gender!=null">
                and (e.gender = #{gender})
            </if>
            <if test="begin!=null and end != null">
                and (e.entry_date between #{begin} and #{end})
            </if>
        </where>
        ```
        根据前端传入的参数进行条件查询。
#### 新增员工
1. 分两个表`emp`和`emp_expr`，分别存储员工基本信息和扩展信息。
在存储expr时使用`<foreach>`
```xml
<insert id="batAddEmpExpr">
        INSERT INTO emp_expr (emp_id, expr_id, expr_value, create_time, update_time)
        VALUES
        <foreach collection="exprList" item="expr" separator=",">
            (#{expr.empId},#{expr.begin},#{expr.end},#{expr.company},#{expr.job})
        </foreach>
</insert>
```
`<foreach>`标签用于遍历集合，`collection`属性指定要遍历的集合，`item`属性指定每次遍历的元素变量名，`separator`属性指定元素之间的分隔符,`open` `close`属性指定开始和结束时拼接的片段。

- 主键返回
    1. 在`mapper.xml`中配置主键返回
    ```xml
    <insert id="addEmp" useGeneratedKeys="true" keyProperty="id">
    ```
    2. 在`Mapper`接口方法前添加
    ```java
    @Options(useGeneratedKeys = true, keyProperty = "id")
    ```

#### 事务管理
在多表操作时，需要使用事务管理来保证数据的一致性和完整性。

### 报表统计
### 登录认证
### 日志管理
### 班级学员管理

## 反向代理
### Nginx配置
1. 安装Nginx
2. 修改Nginx配置文件`nginx.conf`，添加反向代理配置
```nginx
server {
    listen 90;

    location ^~ /api/ {
        rewrite ^/api/(.*)$ /$1 break;
        proxy_pass http://localhost:8080;
        
    }
}
```