package com.finance.service;

import com.notification.service.NotificationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = NotificationApplication.class)
public class NotificationApplicationTest {

	@Autowired
	private ApplicationContext context;

	@Test
	public void contextLoads() {

	}

}
