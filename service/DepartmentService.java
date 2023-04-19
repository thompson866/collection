package pro.sky.com.example.employeeworkdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.com.example.employeeworkdemo.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

  private final EmployeeService employeeService;

  public DepartmentService(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }
  public Employee findEmployeeWithMinSalaryFromDepartment(int department) {
    return employeeService.getAll().stream()
        .filter(employee -> employee.getDepartment() == department)
        .min(Comparator.comparingInt(Employee::getSalary))
        .orElse(null);
  }

  public Employee findEmployeeWithMaxSalaryFromDepartment(int department) {
    return employeeService.getAll().stream()
        .filter(employee -> employee.getDepartment() == department)
        .max(Comparator.comparingInt(Employee::getSalary))
        .orElse(null);
  }

  public Map<Integer, List<Employee>> findEmployeesByDepartment() {
    return employeeService.getAll().stream()
        .collect(Collectors.groupingBy(Employee::getDepartment));
  }

  public List<Employee> findAllEmployeesFromDepartment(int department) {
    return employeeService.getAll().stream()
        .filter(employee -> employee.getDepartment() == department)
        .toList();
  }

}
