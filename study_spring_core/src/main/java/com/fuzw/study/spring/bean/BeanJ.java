package com.fuzw.study.spring.bean;

public abstract class BeanJ {

	public void say() {
		System.out.println("BeanJ: " + this.toString());
		BeanI beanI = getBeanI();
		beanI.say();
	}

	protected abstract BeanI getBeanI();

}
