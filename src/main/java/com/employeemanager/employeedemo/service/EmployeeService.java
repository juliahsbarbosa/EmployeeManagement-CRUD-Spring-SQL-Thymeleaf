package com.employeemanager.employeedemo.service;

import java.util.List;
import com.employeemanager.employeedemo.model.Employee;
import org.springframework.data.domain.Page;


public interface EmployeeService {
    List<Employee> getAllEmployees();

    //create saveEmployee method to add a new employee
    void saveEmployee(Employee employee);


    //create method to search employee by id
    Employee getEmployeeById(long id);

    //create method to delete an employee
    void deleteEmployeeById(long id);

    //Pagination using Spring Data JPA and sorting
    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);





}
