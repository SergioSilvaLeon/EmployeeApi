package com.ssilva.controller;

import com.ssilva.model.Employee;
import com.ssilva.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST)
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateEmployee(
            @PathVariable("id") long employeeId,
            @RequestBody Employee newEmployee
    ) {
        employeeService.updateEmployee(employeeId, newEmployee);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeEmployeeById(long id){
        employeeService.removeEmployeeById(id);
    }

}
