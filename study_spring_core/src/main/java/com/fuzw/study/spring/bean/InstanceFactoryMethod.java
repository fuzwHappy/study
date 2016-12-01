package com.fuzw.study.spring.bean;

public class InstanceFactoryMethod {

	public BeanE getBeanE() {
		return new BeanE();
	}
	
	public BeanF getBeanF(BeanA beanA, BeanB beanB) {
		return new BeanF(beanA, beanB);
	}

}
