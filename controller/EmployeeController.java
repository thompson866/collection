package pro.sky.com.example.employeeworkdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.com.example.employeeworkdemo.model.Employee;
import pro.sky.com.example.employeeworkdemo.sevice.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName);
    }

    @GetMapping("/employee/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/employee/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }
}

