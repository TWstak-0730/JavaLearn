package xyz.twstak.mybatis01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.twstak.mybatis01.pojo.UserMapper;
import xyz.twstak.mybatis01.User;

import java.util.List;

@SpringBootTest
class Mybatis01ApplicationTests {
	@Autowired
	private UserMapper userMapper;


	@Test
	public void testFindAll() {

		List<User> users = userMapper.getUsers();
		users.forEach(System.out::println);
	}

	@Test
	public void testDeleteUser() {
		userMapper.deleteUser(2);
	}

	@Test
	public void testInsertUser() {
		userMapper.insertUser(new User(null,"liming","987654","李明",20));
	}

	@Test
	public void testUpdateUser() {
		userMapper.updateUser(new User(3,"liming","987654","李明",20));
	}
}
