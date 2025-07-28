package xyz.twstak.userlist.controller;

import cn.hutool.core.io.IoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/delete")
    public String deleteUser(Integer id) throws Exception {
        Integer result = userService.DeleteUser(id);
        if (result > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
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
    @RequestMapping("/add")
    public String addUser(@RequestBody User user) throws Exception {
        System.out.println(111);
        try{
            // 设置当前时间为更新时间
            System.out.println(222);
            System.out.println(user);
            Integer result = userService.AddUser(user);
            if (result > 0) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "添加失败，发生异常：" + e.getMessage();
        }

    }

    @RequestMapping("/update")
    public String updateUser(@RequestBody User user) throws Exception {
        try {
            Integer result = userService.UpdateUser(user);
            if (result > 0) {
                return "更新成功";
            } else {
                return "更新失败";
            }
        } catch (Exception e) {
            return "更新失败，发生异常：" + e.getMessage();
        }
    }
    @RequestMapping("/search")
    public List<User> searchUser(@RequestBody User user) throws Exception {
        List<User> usersList = userService.SearchUser(user);
        if (usersList.isEmpty()) {
            System.out.println("没有找到匹配的用户");
        } else {
            System.out.println("找到匹配的用户: " + usersList);
        }
        return usersList;
    }
}
