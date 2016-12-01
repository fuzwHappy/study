package com.fuzw.study.spring.bean;

public class BeanB {

	public void say() {
		System.out.println("BeanB: " + this.toString());
	}

	public static class BeanC {
		public void say() {
			System.out.println("BeanC: " + this.toString());
		}
	}

}
