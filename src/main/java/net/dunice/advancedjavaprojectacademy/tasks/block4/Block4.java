package net.dunice.advancedjavaprojectacademy.tasks.block4;

import net.dunice.advancedjavaprojectacademy.tasks.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Block4 implements Block4Interface {
    @Override
    public List<Employee> printAndGetListEmployees(Employee... employees) {
        Arrays.stream(employees).forEach(item -> System.out.println(
                "First name - " + item.firstName() + "\t" +
                        "Last name - " + item.lastName() + "\t" +
                        "Salary - " + item.salary() + "\t" +
                        "Work years - " + item.workYears()));
        return Arrays.stream(employees).toList();
    }

    @Override
    public List<Employee> getListEmployeesGreaterHundred(List<Employee> employees) {
        return employees.stream().filter(item -> item.salary() > 100000).toList();
    }

    @Override
    public Employee getEmployeeMaxSalary(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::salary))
                .orElse(null);
    }

    @Override
    public Map<String, List<Employee>> getEmployeesGroupedByName(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::firstName));
    }

    @Override
    public Double getSalarySum(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::salary)
                .sum();
    }

    @Override
    public Double getAverageSalary(List<Employee> employees) {
        var result = employees.stream()
                .mapToDouble(Employee::salary)
                .average();
        return result.isPresent() ? result.getAsDouble() : 0.0;
    }
}
