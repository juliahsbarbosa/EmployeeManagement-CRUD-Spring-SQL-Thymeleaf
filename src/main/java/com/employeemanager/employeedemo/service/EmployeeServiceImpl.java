package com.employeemanager.employeedemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.employeemanager.employeedemo.model.Employee;
import com.employeemanager.employeedemo.repository.EmployeeRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;




@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List < Employee > getAllEmployees() {
        return employeeRepository.findAll();
    }

    //implement save employee method to add a new employee
    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);

    }

    //implement get employee by id method
    @Override
    public Employee getEmployeeById(long id) {
        Optional < Employee > optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id : " + id);
        }
        return employee;
    }

    //Implement delete employee method
    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);

    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }

}
