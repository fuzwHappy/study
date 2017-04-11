package com.fuzw.study.spring.container;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.fuzw.study.spring.bean.annotation.ComponentA;
import com.fuzw.study.spring.bean.annotation.ComponentB;
import com.fuzw.study.spring.bean.annotation.ComponentC;
import com.fuzw.study.spring.bean.annotation.ComponentD;
import com.fuzw.study.spring.bean.config.AppConfig;

@Configuration
@Import(AppConfig.class)
public class StudyAnnotationContainer {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("dev");
		ctx.register(AppConfig.class);
		ctx.refresh();

		ComponentA componentA = ctx.getBean(ComponentA.class);
		componentA.say();

		ComponentB componentB = ctx.getBean(ComponentB.class);
		componentB.say();
		ComponentB componentB1 = ctx.getBean(ComponentB.class);
		componentB1.say();

		ComponentC componentC = ctx.getBean(ComponentC.class);
		componentC.say();
		ComponentC componentC1 = ctx.getBean(ComponentC.class);
		componentC1.say();

		ComponentD componentD = ctx.getBean(ComponentD.class);
		componentD.say();

		ComponentD componentD1 = ctx.getBean(ComponentD.class);
		componentD1.say();

		String java_home = ctx.getEnvironment().getProperty("JAVA_HOME");
		System.out.println("JAVA_HOME: " + java_home);
		
		String testa = ctx.getEnvironment().getProperty("test.a");
		System.out.println("test.a: " + testa);
		
		ctx.close();
	}

}
