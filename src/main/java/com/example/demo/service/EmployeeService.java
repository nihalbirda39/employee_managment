package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService{

@Autowired
private EmployeeRepository repo;


public Employee save(Employee e){
return repo.save(e);

}


public List<Employee> getAll(){
return repo.findAll();
}

public Employee getById(Long id){
return repo.findById(id).orElseThrow(()->  new RuntimeException("Employee Not Found"));
}
}

