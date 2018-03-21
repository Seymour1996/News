package mrsj.news;

import mrsj.news.job.KeywordsReceiver;
import mrsj.news.job.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@EnableScheduling
public class NewsApplication {
	/*
 * Redis消息监听器容器
 * 这个容器加载了RedisConnectionFactory和消息监听器
 */
	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
											MessageListenerAdapter listenerAdapter){
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("type"));
		return container;
	}

	/*
	 * 将Receiver注册为一个消息监听器，并指定消息接收的方法（receiveMessage）
	 * 如果不指定消息接收的方法，消息监听器会默认的寻找Receiver中的handleMessage这个方法作为消息接收的方法
	 */
	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver){
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}


	/*
	 * Receiver实例
	 */
	@Bean
	Receiver receiver(CountDownLatch latch){
		return new Receiver(latch);
	}

	@Bean
	CountDownLatch latch(){
		return new CountDownLatch(1);
	}

	/*
	 * Redis Template 用来发送消息
	 */

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class,args);
	}
}
