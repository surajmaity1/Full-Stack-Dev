package com.surajmaity1.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Human {
	@Autowired
	Children children;
	public void speak() {
		System.out.println("Human can speak");
		children.callChildren();
	}
}
