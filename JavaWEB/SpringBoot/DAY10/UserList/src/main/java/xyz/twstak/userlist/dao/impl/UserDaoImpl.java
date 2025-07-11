package xyz.twstak.userlist.dao.impl;

import cn.hutool.core.io.IoUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import xyz.twstak.userlist.dao.UserDao;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("User.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8,new ArrayList<>());
        return lines;
    }
}
