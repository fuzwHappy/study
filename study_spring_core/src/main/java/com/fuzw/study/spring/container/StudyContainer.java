package com.fuzw.study.spring.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fuzw.study.spring.bean.BeanA;
import com.fuzw.study.spring.bean.BeanB;
import com.fuzw.study.spring.bean.BeanB.BeanC;
import com.fuzw.study.spring.bean.BeanD;
import com.fuzw.study.spring.bean.BeanE;
import com.fuzw.study.spring.bean.BeanF;
import com.fuzw.study.spring.bean.BeanG;
import com.fuzw.study.spring.bean.BeanH;

public class StudyContainer {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		
		BeanA a = (BeanA) context.getBean("beanA");
		a.say();
		
		BeanA a1 = context.getBean(BeanA.class);
		a1.say();
		
		System.out.println("a==a1: " + (a==a1));
		
		BeanB b1 = context.getBean("beanB", BeanB.class);
		b1.say();
		
		BeanB b2 = context.getBean("beanB1", BeanB.class);
		b2.say();
		
		BeanB b3 = context.getBean("beanB2", BeanB.class);
		b3.say();
		
		BeanC c = (BeanC) context.getBean("beanC");
		c.say();
		
		BeanC c1 = (BeanC) context.getBean("beanC1");
		c1.say();
		
		BeanD d = context.getBean(BeanD.class);
		d.say();
		
		BeanE e = context.getBean(BeanE.class);
		e.say();
		
		BeanE e1 = (BeanE) context.getBean("beanE");
		e1.say();
		
		BeanF f = (BeanF) context.getBean("beanF");
		f.say();
		
		BeanF f1 = (BeanF) context.getBean("beanF1");
		f1.say();
		
		BeanF f2 = (BeanF) context.getBean("beanF2");
		f2.say();
		
		BeanG g = context.getBean(BeanG.class);
		g.say();
		
		BeanH h = context.getBean(BeanH.class);
		h.say();
	}

}
