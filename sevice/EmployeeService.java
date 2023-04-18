package pro.sky.com.example.employeeworkdemo.sevice;

import org.springframework.stereotype.Service;
import pro.sky.com.example.employeeworkdemo.exception.EmployeeAlreadyAddedException;
import pro.sky.com.example.employeeworkdemo.exception.EmployeeStorageIsFullException;
import pro.sky.com.example.employeeworkdemo.exception.EmployeeNotFoundException;
import pro.sky.com.example.employeeworkdemo.model.Employee;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    private static final int SIZE = 3;
    private final List<Employee> employee = new ArrayList<>(SIZE);

//    @PostConstruct
//    public void init() {
//        employee.add(new Employee("вуди", "вудпекер"));
//        employee.add(new Employee("чилли", "вилли"));
//    }

    public List<Employee> list() {
        return Collections.unmodifiableList(employee);
    }


    public Employee addEmployee(String firstName, String lastName) {
        Employee employeeNew = new Employee(firstName, lastName);
        if (employee.size() < SIZE) {
            for (Employee q : employee) {
                if (q.equals(employeeNew)) {
                    throw new EmployeeAlreadyAddedException();
                }
            }
            employee.add(employeeNew);
            return employeeNew;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employeeNew = new Employee(firstName, lastName);
        if (employee.remove(employeeNew)) {
            return employeeNew;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employeeNew = new Employee(firstName, lastName);
        if (employee.contains(employeeNew)) {
            return employeeNew;
        }
        throw new EmployeeNotFoundException();
    }
}




