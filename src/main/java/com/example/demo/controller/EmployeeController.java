package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController{
    
@Autowired
private  EmployeeService service;

@PostMapping
public Employee create(@Valid @RequestBody EmployeeDTO dto){
Employee e = new Employee();
BeanUtils.copyProperties(dto,e);
return service.save(e);
}

@GetMapping
public List<Employee> getAll(){
return service.getAll();
}


@GetMapping("/{id}")
public Employee getById(@PathVariable Long id){
return service.getById(id);
}
}