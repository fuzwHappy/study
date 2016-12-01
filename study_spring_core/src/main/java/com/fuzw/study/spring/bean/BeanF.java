package com.fuzw.study.spring.bean;

public class BeanF {

	private BeanA a;

	private BeanB b;

	public BeanF(BeanA a, BeanB b) {
		this.a = a;
		this.b = b;
	}

	public void say() {
		System.out.println("BeanF: " + this.toString());
		a.say();
		b.say();
	}
}
