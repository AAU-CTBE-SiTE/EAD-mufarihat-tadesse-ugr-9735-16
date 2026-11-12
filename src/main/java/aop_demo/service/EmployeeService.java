package aop_demo.service;

import aop_demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    // CREATE
    public Employee addEmployee(Employee employee) {

        for (Employee existing : employees) {
            if (existing.getId() == employee.getId()) {
                throw new IllegalArgumentException(
                        "Employee ID already exists!"
                );
            }
        }

        employees.add(employee);

        System.out.println("Employee added successfully!");

        return employee;
    }

    // READ
    public Employee getEmployee(int id) {

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        throw new IllegalArgumentException(
                "Employee with ID " + id + " not found!"
        );
    }

    // UPDATE
    public Employee updateEmployee(int id, Employee updatedEmployee) {

        Employee existingEmployee = getEmployee(id);

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setSalary(updatedEmployee.getSalary());

        System.out.println("Employee updated successfully!");

        return existingEmployee;
    }

    // DELETE
    public boolean deleteEmployee(int id) {

        Employee employee = getEmployee(id);

        employees.remove(employee);

        System.out.println("Employee deleted successfully!");

        return true;
    }

    // READ ALL
    public List<Employee> getAllEmployees() {

        return new ArrayList<>(employees);
    }
}

