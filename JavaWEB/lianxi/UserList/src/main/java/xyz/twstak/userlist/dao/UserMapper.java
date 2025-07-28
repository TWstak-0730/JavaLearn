package xyz.twstak.userlist.dao;

import org.apache.ibatis.annotations.*;
import xyz.twstak.userlist.User;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 根据ID删除用户
     */
    @Delete("DELETE FROM user where id = #{id}")
    public Integer deleteUser(Integer id);

    @Select("SELECT id, username, school, name, age, dateTime as updateTime FROM user")
    public List<User> getUsers();

    @Insert("INSERT INTO user (username, school, name, age, dateTime) VALUES (#{username}, #{school}, #{name}, #{age}, #{updateTime})")
    public Integer insertUser(User user);

    @Update("UPDATE user SET username = #{username}, school = #{school}, name = #{name}, age = #{age}, dateTime = #{updateTime} WHERE id = #{id}")
    public Integer updateUser(User user);

    @Select("SELECT id, username, school, name, age, dateTime as updateTime FROM user WHERE (#{id} IS NULL OR id = #{id}) AND (#{username} IS NULL OR #{username} = '' OR username LIKE CONCAT('%', #{username}, '%')) AND (#{school} IS NULL OR #{school} = '' OR school LIKE CONCAT('%', #{school}, '%')) AND (#{name} IS NULL OR #{name} = '' OR name LIKE CONCAT('%', #{name}, '%')) AND (#{age} IS NULL OR age = #{age})")
    public List<User> searchUser(User user);
}
