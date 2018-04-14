package com.ssilva.service;

import com.ssilva.dao.EmployeeDao;
import com.ssilva.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Collection<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployeeById(long id) {
        return employeeDao.getEmployeeById(id);
    }

    public void removeEmployeeById(long id) {
        employeeDao.removeEmployeeById(id);
    }

    public void updateEmployee(long id, Employee employee) {
        employeeDao.updateEmployee(id, employee);
    }

    public void createEmployee(Employee employee) {
        employeeDao.createEmployee(employee);
    }
}
