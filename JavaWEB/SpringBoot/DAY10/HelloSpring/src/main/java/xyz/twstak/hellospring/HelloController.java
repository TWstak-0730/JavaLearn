package xyz.twstak.hellospring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
