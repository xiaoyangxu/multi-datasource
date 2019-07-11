package com.xxy;

import com.xxy.model.User;
import com.xxy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.xxy.mapper")
public class MultipleDatasourceApplicationTests {
	@Autowired
	private UserService userService;

	@Test
	public void testWrite() {
		User user = new User();
		user.setName("zhangsan");
		userService.insertUser(user);
	}

	@Test
	public void testRead() {
		List<User> list = userService.selectUsers();
		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			System.out.println(user.getName());
		}
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setName("wangwu");
		userService.saveUser(user);
	}
}
