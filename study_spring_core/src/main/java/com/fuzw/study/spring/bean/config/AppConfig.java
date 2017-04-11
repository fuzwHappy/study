package com.fuzw.study.spring.bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.fuzw.study.spring.bean.annotation.ComponentA;
import com.fuzw.study.spring.bean.annotation.ComponentB;

@Configuration
@ComponentScan("com.fuzw.study.spring.bean.annotation")
@PropertySource("classpath:config.properties")
public class AppConfig {

	@Bean
	@Profile("dev")
	@Scope(scopeName = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public ComponentA componentAA() {
		return new ComponentA() {
			public void say() {
				System.out.println("ComponentA: " + this.toString() + " Dev");
			}
		};
	}

	@Bean
	@Profile("pro")
	@Scope(scopeName = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public ComponentA componentA() {
		return new ComponentA() {
			public void say() {
				System.out.println("ComponentA: " + this.toString() + " Pro");
			}
		};
	}

	@Bean(initMethod = "init", destroyMethod = "cleanup")
	public ComponentB componentB(ComponentA componentA) {
		// ComponentA componentA = componentA();
		ComponentB result = new ComponentB();
		result.setComponentA(componentA);
		return result;
	}

}
