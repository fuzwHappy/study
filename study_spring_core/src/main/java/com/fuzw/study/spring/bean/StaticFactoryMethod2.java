package com.fuzw.study.spring.bean;

public class StaticFactoryMethod2 {
	
	public static BeanF getBeanF(BeanA beanA, BeanB beanB) {
		return new BeanF(beanA, beanB);
	}
	
}
