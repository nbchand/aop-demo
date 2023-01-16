package com.nabin.aopdemo.aspects;

import com.nabin.aopdemo.models.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-16
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {

    //specifics the signature of the method in which Aspect needs to be implemented
    //the pointcut below points to the findById method of EmployeeService class
    @Pointcut("execution(* com.nabin.aopdemo.services.EmployeeService.findById(..))")
    private void findEmployeeById() {
    }

    @Pointcut("execution(* com.nabin.aopdemo.services.EmployeeService.findAll(..))")
    private void findAllEmployee() {
    }

    //applying pointcut before method is called
    @Before("findEmployeeById()")
    public void logBeforeEmployeeFetching(JoinPoint joinPoint) {
        log.info("Fetching employee by id from method: {}", joinPoint.getSignature().getName());
    }

    //applying pointcut after method is called (if it returns response successfully)
    @AfterReturning(pointcut = "findEmployeeById()", returning = "employee")
    public void logEmployeeFetched(JoinPoint joinPoint, Employee employee) {
        log.info("Employee has been fetched from method: {}", joinPoint.getSignature().getName());
        log.info("Fetched employee is: {}", employee);
    }

    //applying pointcut after method is called (if it throws an exception)
    @AfterThrowing(pointcut = "findEmployeeById()", throwing = "runtimeException")
    public void logEmployeeFetchedError(JoinPoint joinPoint, RuntimeException runtimeException) {
        log.error("Employee fetching failed from method: {}", joinPoint.getSignature().getName());
        log.error("Cause of error is: {}", runtimeException.getMessage());
    }

    //executes before and after the point cut is proceeded
    @Around(value = "findAllEmployee()")
    public Object aroundFindAllEmployee(ProceedingJoinPoint jp) throws Throwable {
        log.info("The method aroundFindEmployeeById() before invocation of the method {}", jp.getSignature().getName());
        Object stud = jp.proceed();
        log.info("The method aroundFindEmployeeById() after invocation of the method {}", jp.getSignature().getName());
        return stud;
    }

    //executes after the point cut is called
    @After(value = "findAllEmployee()")
    public void afterFindAllEmployee(JoinPoint joinPoint) {
        log.info("Fetching all employees from method: {}", joinPoint.getSignature().getName());
    }
}
