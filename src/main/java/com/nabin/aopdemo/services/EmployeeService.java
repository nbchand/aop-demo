package com.nabin.aopdemo.services;

import com.nabin.aopdemo.models.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-16
 */
@Service
public class EmployeeService {
    private static List<Employee> employees = Arrays.asList(
            new Employee(1, "Ram", "Pokhara"),
            new Employee(2, "Sita", "Kagbeni"),
            new Employee(3, "Gita", "Banepa")
    );

    public Employee findById(Integer id) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid Id"));
    }

    public List<Employee> findAll() {
        return employees;
    }
}
