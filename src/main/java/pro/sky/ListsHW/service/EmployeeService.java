package pro.sky.ListsHW.service;

import org.springframework.stereotype.Service;
import pro.sky.ListsHW.exception.EmployeeAlreadyAddedException;
import pro.sky.ListsHW.exception.EmployeeStorageIsFullException;
import pro.sky.ListsHW.model.Employee;
import pro.sky.ListsHW.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
    private static final int SIZE = 3;
    private final Employee[] employees = new Employee[SIZE];

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (Employee emp : employees) {
            if (emp != null && emp.equals(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return employee;
            }
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!= null && employees[i].equals(employee)) {
                employees[i] = null;
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (Employee emp : employees) {
            if (emp != null && emp.equals(employee)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
}
