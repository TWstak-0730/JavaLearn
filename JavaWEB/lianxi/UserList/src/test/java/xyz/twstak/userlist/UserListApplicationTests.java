package xyz.twstak.userlist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.twstak.userlist.dao.impl.UserDaoImpl;

@SpringBootTest
class UserListApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testDao(){
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		System.out.println(userDaoImpl.findAll());
	}

}
