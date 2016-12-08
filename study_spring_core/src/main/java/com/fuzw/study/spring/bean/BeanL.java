package com.fuzw.study.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.LifecycleProcessor;

public class BeanL implements InitializingBean, DisposableBean, LifecycleProcessor {

	public void say() {
		System.out.println("BeanL: " + this.toString());
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("BeanL: " + this.toString() + " Initializing");
	}
	
	public void afterPropertiesSet2() throws Exception {
		System.out.println("BeanL: " + this.toString() + " Initializing2");
	}

	public void destroy() throws Exception {
		System.out.println("BeanL: " + this.toString() + " Disposable");
	}

	public void destroy2() throws Exception {
		System.out.println("BeanL: " + this.toString() + " Disposable2");
	}

	public void start() {
		System.out.println("BeanL: " + this.toString() + ".start()");
	}

	public void stop() {
		System.out.println("BeanL: " + this.toString() + ".stop()");
	}

	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	public void onRefresh() {
		System.out.println("BeanL: " + this.toString() + ".onRefresh()");
	}

	public void onClose() {
		System.out.println("BeanL: " + this.toString() + ".onClose()");
	}
	
}
