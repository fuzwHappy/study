package com.fuzw.study.javaclass;

import java.awt.List;

public class TestClass {
	public static void main(String[] args) {
		Class strClass = String.class;
		Class listClass = List.class;
		
		System.out.println(strClass.getClass() == listClass.getClass());
		
		
		String[] strs = new String[10];
		String[] strs2 = new String[20];
		Object[] objs = new Object[10];
		System.out.println(strs.getClass() == strs2.getClass());
		System.out.println(strs.getClass() == objs.getClass());
		
	}
}
