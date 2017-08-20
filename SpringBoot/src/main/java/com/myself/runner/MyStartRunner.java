package com.myself.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//import com.myself.persistences.entity.system.User;
//import com.myself.services.system.IUserService;

/*@Component
@Order(value = 1)*/
public class MyStartRunner implements CommandLineRunner {
	
//	@Autowired
//	private IUserService userService;

	@Override
	public void run(String... arg0) throws Exception {
//		User user = new User();
//		user.setUserId("32a05f15396e434a80c13fdf8ad46a2f");
//		user = userService.load(user);
		System.out.println("==== 自定义启动项  ====");
//		System.out.println(user);
	}

}
