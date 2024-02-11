package pro.sky.ListsHW.service;

import org.springframework.stereotype.Service;
import pro.sky.ListsHW.Employee;
import pro.sky.ListsHW.exceptions.EmployeeNotFoundException;

@Service
public class EmployeeService {
    private final Employee[] employees;

    public EmployeeService(Employee[] employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    public void removeEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == employee) {
                employees[i] = null;
                break;
            }
        }
    }

    public Employee findEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == employee) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
}
