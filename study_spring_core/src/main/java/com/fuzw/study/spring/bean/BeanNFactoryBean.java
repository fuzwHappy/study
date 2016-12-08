package com.fuzw.study.spring.bean;

import org.springframework.beans.factory.FactoryBean;

public class BeanNFactoryBean implements FactoryBean<BeanN> {

	public BeanN getObject() throws Exception {
		return new BeanN();
	}

	public Class<?> getObjectType() {
		return BeanN.class;
	}

	public boolean isSingleton() {
		return false;
	}

}
