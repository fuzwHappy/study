package com.fuzw.study.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.fuzw.study.spring.bean.annotation.ComponentA;

public class BeanO {

	@Autowired
	private ComponentA componentA;

	public void say() {
		componentA.say();
		System.out.println("BeanO: " + this.toString());
	}

}
