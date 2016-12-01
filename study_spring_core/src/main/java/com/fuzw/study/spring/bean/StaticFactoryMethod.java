package com.fuzw.study.spring.bean;

public class StaticFactoryMethod {

	private StaticFactoryMethod() {}

	private static BeanD d = new BeanD();

	public static BeanD getBeanD() {
		return d;
	}
	
}
