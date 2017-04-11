package com.fuzw.study.spring.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ComponentC {

	@Autowired
	private ComponentA componentA;

	@Value("${JAVA_HOME}")
	private String java_home;
	
	@Value("${test.a}")
	private String testA;
	
	public void say() {
		componentA.say();
		System.out.println("ComponentC: " + this.toString());
		System.out.println("ComponentC  JAVA_HOME : " + java_home);
		System.out.println("ComponentC  test.a : " + testA);
	}

	public ComponentA getComponentA() {
		return componentA;
	}

	public void setComponentA(ComponentA componentA) {
		this.componentA = componentA;
	}

	@Bean
	public ComponentD componentD() {
		return new ComponentD();
	}

}
