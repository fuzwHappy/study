package com.fuzw.study.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanM implements InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware {

	private BeanL beanL;
	
	private ApplicationContext applicationContext;
	
	private String beanName;
	
	public void say() {
		beanL.say();
		System.out.println("BeanM: " + this.toString());
		System.out.println("BeanM: " + beanName.toString());
		System.out.println("applicationContext: " + applicationContext.toString());
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("BeanM: " + this.toString() + " Initializing");
	}
	
	public void afterPropertiesSet2() throws Exception {
		System.out.println("BeanM: " + this.toString() + " Initializing2");
	}

	public void destroy() throws Exception {
		System.out.println("BeanM: " + this.toString() + " Disposable");
	}
	
	public void destroy2() throws Exception {
		System.out.println("BeanM: " + this.toString() + " Disposable2");
	}
	
	public BeanL getBeanL() {
		return beanL;
	}

	public void setBeanL(BeanL beanL) {
		System.out.println("BeanM: " + this.toString() + " setBeanL");
		this.beanL = beanL;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("BeanM: " + this.toString() + " setApplicationContext");
		this.applicationContext = applicationContext;
	}

	public void setBeanName(String name) {
		this.beanName = name;
	}
	
}
