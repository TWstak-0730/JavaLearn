package xyz.twstak.userlist.controller;

import cn.hutool.core.io.IoUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.twstak.userlist.User;
import xyz.twstak.userlist.service.UserService;
import xyz.twstak.userlist.service.impl.UserServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private UserService userService = new UserServiceImpl();
    @RequestMapping("/list")
    public List<User> getUserList() throws Exception {
        List<User> usersList=userService.getUsers();
        /*
        //1.加载并读取User.txt文件
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("User.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8,new ArrayList<>());
        //2.将文件内容转换为User对象列表
        List<User> usersList = lines.stream().map(
          line -> {
              String[] parts = line.split(",");
              Integer id = Integer.parseInt(parts[0]);
                String username = parts[1];
                String school = parts[2];
                String name = parts[3];
                Integer age = Integer.parseInt(parts[4]);
              LocalDateTime dateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                return new User(id, username, school, name, age, dateTime);
          }
        ).toList();
        //3.返回User对象列表的JSON格式字符串
        */
        return usersList;
    }
}
