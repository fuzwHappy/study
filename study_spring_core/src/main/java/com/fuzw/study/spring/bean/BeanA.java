package com.fuzw.study.spring.bean;

public class BeanA {

	public BeanA() {
		System.out.println("BeanA instance: " + this.toString());
	}
	
	public void say() {
		System.out.println("BeanA: " + this.toString());
	}

}
