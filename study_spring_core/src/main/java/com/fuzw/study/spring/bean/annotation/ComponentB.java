package com.fuzw.study.spring.bean.annotation;

public class ComponentB {

	private ComponentA componentA;

	public void say() {
		componentA.say();
		System.out.println("ComponentB: " + this.toString());
	}

	public ComponentA getComponentA() {
		return componentA;
	}

	public void setComponentA(ComponentA componentA) {
		System.out.println("ComponentB: " + this.toString() + " setComponentA");
		this.componentA = componentA;
	}
	
	public void init() {
		System.out.println("ComponentB: " + this.toString() + " init");
	}

	public void cleanup() {
		System.out.println("ComponentB: " + this.toString() + " cleanup");
	}

}
