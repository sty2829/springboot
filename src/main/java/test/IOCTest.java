package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {

	private Coffee coffee;
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ioc1.xml");
		ac.getBean("coffee");
	}
}
