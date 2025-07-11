### Spring Boot

创建时间：2025.7.10

#### Spring简介

Spring是一个开源的Java EE框架，旨在简化企业级应用程序的开发。它提供了全面的基础设施支持，使开发者能够专注于业务逻辑而不是底层细节。Spring的核心特性包括依赖注入（DI）、面向切面编程（AOP）和事务管理等。
#### 启动类创建

```JAVA
@SpringBootApplication
public class HelloSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);
    }

}
```

#### 请求类创建

```JAVA
@RestController //标注这是一个控制器类
public class HelloController {

    @RequestMapping("/hello") //映射请求路径为/hello
    //当访问/hello时，调用sayHello方法
    //并返回一个字符串
    //如果请求中包含name参数，则返回"Hello, Spring! name"
    //否则返回"Hello, Spring!"
    public String sayHello(String name) {
        return "Hello, Spring!"+ (name != null ? " " + name : "");
    }

}
```
#### http协议

##### 请求数据格式

- 请求行：请求数据格式的第一行，包含请求方法、请求路径和HTTP版本。
- 请求头：请求数据格式的第二行开始，包含请求的元信息，如主机、内容类型等。以键值对形式存在，每行一个。
    - 常见的请求头包括：
        - Host：指定请求的主机和端口。
        - User-Agent：浏览器或客户端的标识信息。
        - Accept：客户端能够处理的内容类型。
        - Accept-Language：客户端能够处理的语言类型。
        - Accept-Encoding：客户端能够处理的编码类型。
        - Content-Type：请求体的内容类型，通常在POST请求中使用。
        - Content-Length：请求体的长度，通常在POST请求中使用。
- 空行：请求头和请求体之间的空行，表示请求头结束。
- 请求体：可选部分，包含请求的具体内容。POST请求通常会有请求体，而GET请求一般没有。


- GET：
    ```
    GET /hello?name=John HTTP/1.1
    Host: localhost:8080
    ```
- POST：
    ```
    POST /hello HTTP/1.1
    Host: localhost:8080
    Content-Type: application/x-www-form-urlencoded

    name=John
    ```

##### 请求数据的获取

后端web服务器对HTTP请求数据进行解析，并进行封装（HttpServletRequest）。开发者可以通过HttpServletRequest对象获取请求的各种信息，如请求参数、请求头、请求体等。在调用控制器方法时，Spring会自动将请求数据映射到方法参数上。

```JAVA
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(HttpServletRequest request) {
        String name = request.getParameter("name"); // 获取请求参数name的值
        String url = request.getRequestURL().toString(); // 获取请求的完整URL
        String method = request.getMethod(); // 获取请求方法（GET、POST等）
        return "Hello, Spring!" + (name != null ? " " + name : "");
    }

}
```

##### 响应数据格式

- 响应行：响应数据格式的第一行，包含HTTP版本、状态码和状态描述。
    - 状态码：
        - 1xx:响应中-临时状态码
        - 2xx:成功状态码
        - 3xx:重定向状态码
        - 4xx:客户端错误状态码
        - 5xx:服务器错误状态码
- 响应头：响应数据格式的第二行开始，包含响应的元信息
    - 常见的响应头包括：
        - Content-Type：响应体的内容类型，指示客户端如何处理响应内容。
        - Content-Length：响应体的长度，指示客户端接收的数据量。
        - Set-Cookie：设置Cookie信息，用于会话管理。
        - Cache-Control：缓存控制指令，指示客户端如何缓存响应内容。
- 空行：响应头和响应体之间的空行，表示响应头结束。
- 响应体：包含实际的响应内容，如HTML、JSON、XML等。

##### 响应数据的返回

```JAVA
@RestController
public class RequesController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String header = request.getHeader("User-Agent");
        String requestURI = request.getRequestURI();
        String requestURL = request.getRequestURL().toString();
        String method = request.getMethod();
        return "Hello, this is a request response!";
    }
}
```

##### 代码说明
- `@RestController` = `@Controller` + `@ResponseBody`
    - `@Controller`：标注这是一个控制器类，用于处理请求。
    - `@ResponseBody`：表示方法的返回值将直接作为响应体返回，而不是视图名称。
    - 如果是对象或者是集合，Spring会自动将其转换为JSON格式返回。

### 三层架构

- 表示层（Controller）：负责处理用户请求，返回视图或数据。
- 业务逻辑层（Service）：负责处理具体的业务逻辑，调用数据访问层。
- 数据访问层（Repository）：负责与数据库进行交互，执行CRUD操作。

### 分层解耦

- 耦合：指模块之间的依赖关系，耦合度越高，模块之间的依赖关系越紧密。
- 内聚