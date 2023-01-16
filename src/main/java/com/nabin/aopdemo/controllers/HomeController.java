package com.nabin.aopdemo.controllers;

import com.nabin.aopdemo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-16
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> sayHello() {
        return new ResponseEntity<>("Hello Everyone!", HttpStatus.OK);
    }

    @GetMapping("/employee/all")
    public ResponseEntity<?> findAllEmployee() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> findEmployeeById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }
}
