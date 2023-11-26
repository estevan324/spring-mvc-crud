package com.eshernandes.springboot.thymeleafdemo.dao;

import com.eshernandes.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { }
