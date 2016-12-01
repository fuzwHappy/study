package com.fuzw.study.spring.bean;

public class BeanH {

	private BeanG beanG;
	
	public BeanH() {
		System.out.println("BeanH instance: " + this.toString());
	}

//	public BeanH(BeanG beanG) {
//		this.beanG = beanG;
//	}

	public BeanG getBeanG() {
		return beanG;
	}

	public void setBeanG(BeanG beanG) {
		this.beanG = beanG;
	}

	public void say() {
		System.out.println("BeanH: " + this.toString());
	}

}
