package com.ssilva.dao;

import com.ssilva.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FakeEmployeeDaoImpl implements EmployeeDao{

    private static List<Employee> employees;
    private static AtomicLong nextId = new AtomicLong();

    static {
        employees = new ArrayList<>();

        employees.add(new Employee(nextId.incrementAndGet(),"Sergio","Silva"));
        employees.add(new Employee(nextId.incrementAndGet(),"Juan","Perez"));
        employees.add(new Employee(nextId.incrementAndGet(),"Oscar","Leon"));

    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(long id) {
        for (Employee employee: employees){
            if (employee.getId()==id){
                return employee;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public void removeEmployeeById(long id) {
        employees.remove(id);
    }

    @Override
    public void updateEmployee(long employeeId, Employee newEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employees.remove(employee);
                newEmployee.setId(employeeId);
                employees.add(newEmployee);
                continue;
            }
        }

        throw new IllegalArgumentException();

    }

    @Override
    public void createEmployee(Employee employee) {
        // set Employee to have next ID
        employee.setId(nextId.incrementAndGet());

        employees.add(employee);
    }
}
