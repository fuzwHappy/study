package com.fuzw.study.dubbo.services.impl;

import com.fuzw.study.dubbo.services.DemoService;

public class DemoServiceImpl implements DemoService {

	public String say(String str) {
		return str + " Hello! World!";
	}

}
