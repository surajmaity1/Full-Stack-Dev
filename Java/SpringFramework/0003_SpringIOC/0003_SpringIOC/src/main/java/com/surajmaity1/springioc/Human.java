package com.surajmaity1.springioc;

public class Human {
	
	private int age;
	private Children children;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("Age is assigned ...");
		this.age = age;
	}

	public Human() {
		System.out.println("Human object is created ...");
	}
	
	public void speak() {
		System.out.println("Human can speak");
		children.walk();
	}
}
