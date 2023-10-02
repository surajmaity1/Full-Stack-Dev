package oops;

// Program where super is used to refer immediate parent class instance variable


class Class1 {
	String name = "Parent Class 1";
}

class ChildOfClass1  extends Class1{
	String name = "Child of Parent Class 1";
	void printName() {
		System.out.println(name);
		System.out.println(super.name);
	}
}


//Program where super can be used to invoke parent class method
class Class2 {
	void walk() {
		System.out.println("Walk using 4 legs.");
	}
}

class ChildOfClass2 extends Class2 {
	void walk() {
		System.out.println("Walk using 2 legs.");
	}
	void eat() {
		System.out.println("Eat ...");
	}
	
	void display() {
		walk();
		super.walk();
		eat();
	}
}



//Program where super is used to invoke parent class constructor.

class Class3 {
	Class3(){
		System.out.println("Class3 is created.");
	}
}

class ChildOfClass3 extends Class3 {
	// We need to call inside child class's constructor
	//super();
	
	ChildOfClass3() {
		// note: Constructor call must be the first statement in a constructor
		super();
		System.out.println("ChildOfClass3 is created.");
	}
}

// REAL LIFE EXAMPLE OF super keyword

class StudentData {
	int id;
	String name;
	
	StudentData(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

class EngineeringStudent extends StudentData {
	String department;
	EngineeringStudent(int id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	void display() {
		System.out.println("Student's id: " + id);
		System.out.println("Student's name: " + name);
		System.out.println("Student's department: " + department);
	}
}

public class SuperKeyWordExample{

	public static void main(String[] args) {
		System.out.println("\n\n###################\n\n");
		// program for instance variable
		ChildOfClass1 c1 = new ChildOfClass1();
		c1.printName();
		
		

		System.out.println("\n\n###################\n\n");
		// program for method
		ChildOfClass2 c2 = new ChildOfClass2();
		c2.display();
		
		System.out.println("\n\n###################\n\n");
		
		// program for constructor
		ChildOfClass3 c3 = new ChildOfClass3();
		

		System.out.println("\n\n###################\n\n");
		// REAL LIFE EXAMPLE
		EngineeringStudent es = new EngineeringStudent(1, "Student1", "CSE");
		es.display();
	}

}
