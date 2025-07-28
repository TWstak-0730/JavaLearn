package xyz.twstak.userlist.service;

import xyz.twstak.userlist.User;

import java.util.List;

public interface UserService {
    /**
     * 解析用户信息
     *
     */
    public List<User> getUsers();
    public Integer DeleteUser(Integer id);
    public Integer AddUser(User user);
    public Integer UpdateUser(User user);
    public List<User> SearchUser(User user);
}
