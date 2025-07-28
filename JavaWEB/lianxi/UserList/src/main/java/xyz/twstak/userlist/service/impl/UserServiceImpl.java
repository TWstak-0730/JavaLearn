package xyz.twstak.userlist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xyz.twstak.userlist.User;
import xyz.twstak.userlist.dao.UserDao;
import xyz.twstak.userlist.dao.impl.UserDaoImpl;
import xyz.twstak.userlist.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getUsers() {
        List<User> usersList = userDao.getUser();
        return usersList;
    }
    @Override
    public Integer DeleteUser(Integer id) {
        return userDao.DeleteUser(id);
    }
    @Override
    public Integer AddUser(User user) {
        user.setUpdateTime(LocalDateTime.now());
        return userDao.AddUser(user);
    }

    @Override
    public Integer UpdateUser(User user) {
        user.setUpdateTime(LocalDateTime.now());
        return userDao.UpdateUser(user);
    }

    @Override
    public List<User> SearchUser(User user) {
        return userDao.SearchUser(user);
    }
}
