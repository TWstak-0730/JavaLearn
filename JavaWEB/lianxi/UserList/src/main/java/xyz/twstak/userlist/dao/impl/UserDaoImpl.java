package xyz.twstak.userlist.dao.impl;

import cn.hutool.core.io.IoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import xyz.twstak.userlist.User;
import xyz.twstak.userlist.dao.UserDao;
import xyz.twstak.userlist.dao.UserMapper;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<String> findAll() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("User.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8,new ArrayList<>());
        return lines;
    }

    @Override
    public List<User> getUser() {
        return userMapper.getUsers();
    }

    @Override
    public Integer DeleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public Integer AddUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Integer UpdateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> SearchUser(User user) {
        return userMapper.searchUser(user);
    }
}
