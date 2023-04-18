package pro.sky.com.example.employeeworkdemo.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.com.example.employeeworkdemo.model.Employee;
import pro.sky.com.example.employeeworkdemo.sevice.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String welcome() {
        return "Привет";
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping("/all")
    public List<Employee> list(){
        return employeeService.list();
    }

}

