package com.fuzw.study.spring.bean;

public class BeanG {

	private BeanH beanH;

//	public BeanG(BeanH beanH) {
//		this.beanH = beanH;
//	}

	public BeanH getBeanH() {
		return beanH;
	}

	public void setBeanH(BeanH beanH) {
		this.beanH = beanH;
	}

	public void say() {
		System.out.println("BeanG: " + this.toString());
	}

}
