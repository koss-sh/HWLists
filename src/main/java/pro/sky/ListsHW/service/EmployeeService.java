package pro.sky.ListsHW.service;

import org.springframework.stereotype.Service;
import pro.sky.ListsHW.exception.EmployeeAlreadyAddedException;
import pro.sky.ListsHW.exception.EmployeeStorageIsFullException;
import pro.sky.ListsHW.model.Employee;
import pro.sky.ListsHW.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private final int SIZE = 3;
    private List<Employee> employees = new ArrayList<>(SIZE);

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < SIZE) {
            if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.remove(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
