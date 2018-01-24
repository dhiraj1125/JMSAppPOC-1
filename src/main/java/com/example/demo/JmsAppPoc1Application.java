package com.example.demo;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class JmsAppPoc1Application {

	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer){
		DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
		configurer.configure(containerFactory, connectionFactory);
		
		return containerFactory;
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JmsAppPoc1Application.class, args);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		System.out.println("sending a jms message");
		jmsTemplate.convertAndSend("sampleQueue", "Hello world!");
	}
}
