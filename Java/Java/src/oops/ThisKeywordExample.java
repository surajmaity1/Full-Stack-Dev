package oops;

// this: to refer current class instance variable

class Student {
	int rollno;
	String name;
	float fee;

	Student(int rollno, String name, float fee) {
		this.rollno = rollno;
		this.name = name;
		this.fee = fee;
	}

	void display() {
		System.out.println(rollno + " " + name + " " + fee);
	}
}

// this: to invoke current class method
class A {
	void m() {
		System.out.println("hello m");
	}

	void n() {
		System.out.println("hello n");
		// m();//same as this.m()
		this.m();
	}
}

// this() : to invoke current class constructor
class A2 {
	A2() {
		System.out.println("hello a");
	}

	A2(int x) {
		this();
		System.out.println(x);
	}
}

// Calling parameterized constructor from default constructor:
class A3 {
	A3() {
		this(5);
		System.out.println("hello A3");
	}

	A3(int x) {
		System.out.println(x);
	}
}

//Real usage of this() constructor call
class Student2 {
	int rollno;
	String name, course;
	float fee;

	Student2(int rollno, String name, String course) {
		this.rollno = rollno;
		this.name = name;
		this.course = course;
	}

	Student2(int rollno, String name, String course, float fee) {
		// Call to this() must be the first statement in constructor.
		this(rollno, name, course);// reusing constructor
		this.fee = fee;
	}

	void display() {
		System.out.println(rollno + " " + name + " " + course + " " + fee);
	}
}

// this: to pass as an argument in the method
/*
 * Note: Application of this that can be passed as an argument: In event
 * handling (or) in a situation where we have to provide reference of a class to
 * another one. It is used to reuse one object in many methods.
 */
class S2 {
	void m(S2 obj) {
		System.out.println("method is invoked");
	}

	void p() {
		m(this);
	}
}

// this: to pass as argument in the constructor call
class B {
	ThisKeywordExample obj;

	B(ThisKeywordExample obj) {
		this.obj = obj;
	}

	void display() {
		System.out.println(obj.data);// using data member of A4 class
	}
}

class Ab {
	Ab getA() {
		return this;
	}

	void msg() {
		System.out.println("Hello java");
	}
}

public class ThisKeywordExample {

	int data = 10;

	ThisKeywordExample() {
		B b = new B(this);
		b.display();
	}
	
	//  prove that this keyword refers to the current class instance variable.
	void m(){  
		System.out.println(this);//prints same reference ID  
		}  

	public static void main(String[] args) {

		System.out.println("\n\n####################\n\n");
		Student s1 = new Student(111, "ankit", 5000f);
		Student s2 = new Student(112, "sumit", 6000f);
		s1.display();
		s2.display();

		System.out.println("\n\n####################\n\n");

		A a = new A();
		a.n();

		System.out.println("\n\n####################\n\n");
		A2 a2 = new A2(10);

		System.out.println("\n\n####################\n\n");
		A3 a3 = new A3();

		System.out.println("\n\n####################\n\n");

		System.out.println("\n\n####################\n\n");
		Student2 s12 = new Student2(111, "ankit", "java");
		Student2 s22 = new Student2(112, "sumit", "java", 6000f);
		s12.display();
		s22.display();

		System.out.println("\n\n####################\n\n");
		S2 s122 = new S2();
		s122.p();

		System.out.println("\n\n####################\n\n");
		ThisKeywordExample aThisKeywordExample = new ThisKeywordExample();

		System.out.println("\n\n####################\n\n");
		new Ab().getA().msg();
		
		System.out.println("\n\n####################\n\n");
		ThisKeywordExample obj=new ThisKeywordExample();  
		System.out.println(obj);//prints the reference ID  
		obj.m();  
	}

}
