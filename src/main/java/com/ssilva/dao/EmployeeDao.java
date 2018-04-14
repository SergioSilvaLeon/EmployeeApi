package com.ssilva.dao;

import com.ssilva.model.Employee;

import java.util.Collection;

public interface EmployeeDao {

    Collection<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    void removeEmployeeById(long id);

    void updateEmployee(long id, Employee employee);

    void createEmployee(Employee employee);
}
