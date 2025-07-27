package xyz.twstak.mybatis01.pojo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.twstak.mybatis01.User;

import java.util.List;

@Mapper // 程序运行时会自动扫描到这个接口，并生成代理对象，并将该实现类注册到Spring容器中 - bean
public interface UserMapping {
    @Select("select * from user") // 直接使用SQL语句
    public List<User> getUsers();
}
