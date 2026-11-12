package aop_demo;

import aop_demo.model.Employee;
import aop_demo.service.EmployeeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopDemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner run(EmployeeService employeeService) {

		return args -> {

			System.out.println("\n========== ADD EMPLOYEES ==========");

			employeeService.addEmployee(
					new Employee(1, "Abebe", "IT", 25000)
			);

			employeeService.addEmployee(
					new Employee(2, "Hana", "HR", 20000)
			);

			employeeService.addEmployee(
					new Employee(3, "Dawit", "Finance", 30000)
			);


			System.out.println("\n========== GET EMPLOYEE ==========");

			Employee employee = employeeService.getEmployee(1);

			System.out.println("Found: " + employee);


			System.out.println("\n========== UPDATE EMPLOYEE ==========");

			Employee updatedEmployee =
					new Employee(1, "Abebe Tadesse", "Software", 35000);

			employeeService.updateEmployee(1, updatedEmployee);


			System.out.println("\n========== GET ALL EMPLOYEES ==========");

			employeeService.getAllEmployees().forEach(System.out::println);


			System.out.println("\n========== DELETE EMPLOYEE ==========");

			employeeService.deleteEmployee(2);


			System.out.println("\n========== TEST EXCEPTION ==========");

			try {

				employeeService.getEmployee(99);

			} catch (IllegalArgumentException e) {

				System.out.println(
						"Application handled: " + e.getMessage()
				);

			}


			System.out.println("\n========== FINAL EMPLOYEE LIST ==========");

			employeeService.getAllEmployees().forEach(System.out::println);

		};
	}
}


