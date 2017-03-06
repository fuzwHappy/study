package com.fuzw.study.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fuzw.study.dubbo.services.DemoService;

public class ServicesConsumerApp {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "consumer.xml" });
		context.start();

		DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理

		for (int i = 0;;) {
			String hello = demoService.say("AA" + i++); // 执行远程方法
			System.out.println(hello); // 显示调用结果
		}
	}

}
