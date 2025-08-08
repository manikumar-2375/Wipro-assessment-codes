package com.example.employeeservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id, @RequestHeader(value = "X-Request-Source", required = false) String source) {
        return new Employee(id, "John Doe", "Engineering", source != null ? source : "Unknown");
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee,
                                   @RequestHeader(value = "X-Request-Source", required = false) String source) {
        employee.setSource(source != null ? source : "Unknown");
        return employee;
    }
}
