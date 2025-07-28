package xyz.twstak.mybatis01.pojo;

import org.apache.ibatis.annotations.*;
import xyz.twstak.mybatis01.User;

import java.util.List;

@Mapper // 程序运行时会自动扫描到这个接口，并生成代理对象，并将该实现类注册到Spring容器中 - bean
public interface UserMapper {
    public List<User> getUsers();

    /**
     * 根据ID删除用户
     */
    @Delete("DELETE FROM user where id = #{id}")
    public Integer deleteUser(Integer id);

    /**
     * 新增用户
     * @param user
     */
    @Insert("INSERT INTO user(username,password,name,age) values(#{username},#{password},#{name},#{age})")
    public Integer insertUser(User user);

    @Update("UPDATE user SET username = #{username}, password = #{password} , name = #{name},age = #{age} where id = #{id}")
    public Integer updateUser(User user);
}
