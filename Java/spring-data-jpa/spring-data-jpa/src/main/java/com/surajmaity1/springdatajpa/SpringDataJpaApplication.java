package com.surajmaity1.springdatajpa;

import com.surajmaity1.springdatajpa.users.Employee;
import com.surajmaity1.springdatajpa.users.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner{

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee1 = new Employee("A",
					"a", "a@gmail.com", 323);
		Employee employee2 = new Employee("B",
				"b", "b@gmail.com", 324);
		Employee employee3 = new Employee("A",
				"c", "ac@gmail.com", 323);
		Employee employee4 = new Employee("D",
				"d", "d@gmail.com", 324);
		Employee employee5 = new Employee("E",
				"e", "e@gmail.com", 324);
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
		employeeRepository.save(employee4);
		employeeRepository.save(employee5);

		employeeRepository.findById(2L).ifPresent(
				System.out::println
		);
		employeeRepository.findByEmpDeptNo(323).forEach(
				System.out::println
		);


		employeeRepository.findByEmpFirstName("A").forEach(
				System.out::println
		);
		System.out.println("NO of Data Before Delete: " + employeeRepository.count());
		employeeRepository.deleteById(3L);
		System.out.println("NO of Data After Delete: " + employeeRepository.count());
	}

//	@Bean
//	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
//		return args -> {
//			Employee employee = new Employee("Rajat",
//					"Sharma", "rs@gmail.com", 323);
//			employeeRepository.save(employee);
//		};
//	}

}
