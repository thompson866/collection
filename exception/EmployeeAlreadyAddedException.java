package pro.sky.com.example.employeeworkdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class EmployeeAlreadyAddedException extends RuntimeException{
}
