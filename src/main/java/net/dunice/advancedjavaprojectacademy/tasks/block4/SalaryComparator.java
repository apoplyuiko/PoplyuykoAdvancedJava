package net.dunice.advancedjavaprojectacademy.tasks.block4;

import net.dunice.advancedjavaprojectacademy.tasks.Employee;
import org.apache.logging.log4j.util.PropertySource;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.salary().compareTo(employee2.salary());
    }
}