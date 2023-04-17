package pro.sky.com.example.employeeworkdemo.sevice;

import org.springframework.stereotype.Service;
import pro.sky.com.example.employeeworkdemo.exception.EmployeeAlreadyAddedException;
import pro.sky.com.example.employeeworkdemo.exception.EmployeeStorageIsFullException;
import pro.sky.com.example.employeeworkdemo.exception.EmployeeNotFoundException;
import pro.sky.com.example.employeeworkdemo.model.Employee;

@Service
public class EmployeeService {

    private static final int SIZE =4;
    private final Employee[] employee = new Employee[SIZE];

    public Employee addEmployee(String firstName, String lastName) {
        int startEmp = -1;
        Employee employeeNew = new Employee(firstName, lastName);
        for (int i = 0; i < employee.length; i++) {
            if (employeeNew == null && startEmp == -1) {
                startEmp = i;
            }
            if (employee[i] == null && employee[i].equals(employeeNew)) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        if (startEmp != -1) {
            throw new EmployeeStorageIsFullException();
        }
        employee[startEmp] = employeeNew;
        return employee[startEmp];
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employeeNew = new Employee(firstName, lastName);
        for (Employee employee : employee) {
            if (employee.equals(employeeNew)) {
                return employeeNew;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employeeNew = new Employee(firstName, lastName);
        for (int i = 0; i < employee.length; i++) {
            if (employeeNew.equals(employee[i])) {
                employee[i] = null;

                return employeeNew;
            }
        }
        throw new EmployeeNotFoundException();
    }
}