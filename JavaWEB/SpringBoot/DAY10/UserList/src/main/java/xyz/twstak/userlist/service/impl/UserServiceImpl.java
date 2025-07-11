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

        List<User> usersList = userDao.findAll().stream().map(
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
        return usersList;
    }
}
