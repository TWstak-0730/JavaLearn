package xyz.twstak.userlist.dao;

import xyz.twstak.userlist.User;

import java.util.List;

public interface UserDao {
    /**
     * 加载用户数据
     * */
    public List<String> findAll();

    public List<User> getUser();
    /**
     * 删除用户数据
     * */
    public Integer DeleteUser(Integer id);

    public Integer AddUser(User user);

    public Integer UpdateUser(User user);

    public List<User> SearchUser(User user);
}
