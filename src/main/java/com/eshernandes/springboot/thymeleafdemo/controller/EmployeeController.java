package com.eshernandes.springboot.thymeleafdemo.controller;

import com.eshernandes.springboot.thymeleafdemo.entity.Employee;
import com.eshernandes.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> employees = employeeService.findAllByOrderByLastNameAsc();

        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/create")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());

        return "employees/employee-form";
    }

    @GetMapping("/update")
    public String updateEmployee(
            @RequestParam("employeeId") int employeeId, Model model) {

        Employee employee = employeeService.findById(employeeId);

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(
            @ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees/list";
    }
}
