package com.vishal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    Service service;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        service.add(employee);
        return employee;
    }

    @PutMapping("/update-employee/{id}")
    public Employee employee(@PathVariable int id,@RequestBody Employee employee){
        Employee emp=service.updateEmployee(id,employee);
        if(emp==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return emp;
    }

    @GetMapping("/get-employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee emp=service.getEmployee(id);
        if(emp==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return emp;
    }

    @GetMapping("/get-allEmployees")
    public List<Employee> getAllEmployees(){
        List<Employee> emp=service.getAllEmployees();
        if(emp.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return emp;
    }

    @DeleteMapping("/delete-employee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);
    }
}

