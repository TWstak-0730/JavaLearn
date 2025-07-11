package xyz.twstak.userlist.service;

import xyz.twstak.userlist.User;

import java.util.List;

public interface UserService {
    /**
     * 解析用户信息
     *
     */
    public List<User> getUsers();
}
