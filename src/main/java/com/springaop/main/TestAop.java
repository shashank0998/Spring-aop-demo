package com.springaop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springaop.config.SpringConfig;
import com.springaop.service.Calculator;

public class TestAop {

	public static void main(String[] args) throws InterruptedException 
	{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		
		//Calculator cal = new Calculator();
		
		Calculator cal = ctx.getBean(Calculator.class);
		
		
		//cal.print();
		cal.sum(10, 20);
		//cal.addition(10L, 20L);
	}

}
