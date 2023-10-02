package collectionsFramework;


interface Task {
	void taskMethod();
}

class Runner {
	public void run(Task t) {
		System.out.println("Runner's run() block executing ...");
		t.taskMethod();
	}
}

interface Task2 {
	int taskMethod2();
}

class Runner2 {
	public void run(Task2 t) {
		System.out.println("Runner's run() block executing ...");
		int val = t.taskMethod2();
		System.out.println("Return: " + val);
	}
}

interface Task3 {
	int taskMethod3(int x);
}
interface StringTask3 {
	String taskMethod3(String x);
}
class Runner3 {
	public void run3(Task3 t) {
		System.out.println("Runner's run3() block executing ...");
		int val = t.taskMethod3(32);
		System.out.println("Return: " + val);
	}
	public void run3(StringTask3 t) {
		System.out.println("Runner's run3() block executing ...");
		String val = t.taskMethod3("Hi");
		System.out.println("Return: " + val);
	}
}



interface Task4 {
	int taskMethod4(int x, int y);
}
interface StringTask4 {
	String taskMethod4(String x);
}
class Runner4 {
	public void run4(Task4 t) {
		System.out.println("Runner's run3() block executing ...");
		int val = t.taskMethod4(2, 54);
		System.out.println("Return: " + val);
	}
}
public class LambdaExpressionPractice {

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.run(new Task() {

			@Override
			public void taskMethod() {
				System.out.println("Task is executing ...");
			}
			
		});
		
		
		System.out.println("\n\n###########################\n\n");
		
		
		// shorter version of above code using lambda
		runner.run(() -> System.out.println("Task is executing ..."));
		

		
		System.out.println("\n\n###########################\n\n");
		
		// shorter version of above code using lambda
		// and put multiple line
		runner.run(() ->{
			System.out.println("Task 1 is executing ...");
			System.out.println("Task 2 is executing ...");
			System.out.println("Task 3 is executing ...");
		} );
		
				
		
		
		System.out.println("\n\n###########################\n\n");
		
		System.out.println("----------With Return Type ------------");
		Runner2 runner2 = new Runner2();
		runner2.run(new Task2() {
			
			@Override
			public int taskMethod2() {
				return 53;		
			}
		});
		
		System.out.println("\n\n###########################\n\n");
		
		
		// shorter version of above code using lambda
		runner2.run(() -> {
			return 42;
		});
		
		// shorter version of above code using lambda
		runner2.run(() -> 44);

		
		System.out.println("\n\n###########################\n\n");
		
		// shorter version of above code using lambda
		// and put multiple line
		runner2.run(() ->{
			System.out.println("Task 1 is executing ...");
			System.out.println("Task 2 is executing ...");
			System.out.println("Task 3 is executing ...");
			return 543;		
		} );
		
		Runner3 runner3 = new Runner3();
		runner3.run3(new Task3() {

			@Override
			public int taskMethod3(int x) {
				// TODO Auto-generated method stub
				return 442+x;
			}
			
		});
		
		// shorter version of above code using lambda
		
		/*
		 Note: when two method have same name and same no. of parameters,
		 we need to specify data type of parameter's variable
		 here like - 
		 int z 
		 String t
		 */
		runner3.run3((int z) -> 32+z);	
		
		runner3.run3((String t) -> t + " Mr. X");	
		
		
		
		System.out.println("\n\n###########################\n\n");
		
		Runner4 r4 = new Runner4();
		r4.run4((a,b) -> a*b);
		
		// This below code is same as above		
		Task4 t1 = (int a,int b) -> a*b;
		r4.run4(t1);

		// This below code is same as above		
		Object t2 = (Task4)(int a,int b) -> a*b;
		r4.run4((Task4)t2);
		
		System.out.println("\n\n###########################\n\n");
		
		int zz = 23;
		// you can't do this -->   zz = 3;
		// this error will be showing. error :- Local variable zz defined in an enclosing scope must be final or effectively final
		
		int nn = 32;
		r4.run4(new Task4() {
			
			@Override
			public int taskMethod4(int x, int y) {
				return x + y + zz;
			}
		});
		
		r4.run4((a,b) -> {
			return a + b + zz;
		});
		
		
		
		
		
	}

}
