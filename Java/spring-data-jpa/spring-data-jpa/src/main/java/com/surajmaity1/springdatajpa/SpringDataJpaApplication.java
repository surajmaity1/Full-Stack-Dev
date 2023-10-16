package com.surajmaity1.springdatajpa;

import com.surajmaity1.springdatajpa.users.Employee;
import com.surajmaity1.springdatajpa.users.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
		return args -> {
			Employee employee = new Employee("Rajat",
					"Sharma", "rs@gmail.com", 323);
			employeeRepository.save(employee);
		};
	}

}
