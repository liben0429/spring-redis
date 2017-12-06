package test;

import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niubi.utils.JedisClient;

public class TestRedis {
	
	@SuppressWarnings("resource")
	@Test
	public void testJedisClient()throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		JedisClient js =  applicationContext.getBean(JedisClient.class);
		js.set("l", "123");
	}
	
	@SuppressWarnings("resource")
	@Test
	public void testJedisClientPool() throws Exception {
		//初始化spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
		//从容器中获得JedisClient对象
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		//使用JedisClient对象操作redis
		jedisClient.set("jedisclient", "mytest");
		String result = jedisClient.get("jedisclient");
		System.out.println(result);
	}
}
