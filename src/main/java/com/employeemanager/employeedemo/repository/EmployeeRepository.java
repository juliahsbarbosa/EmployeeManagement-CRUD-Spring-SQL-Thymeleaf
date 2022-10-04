package com.employeemanager.employeedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employeemanager.employeedemo.model.Employee;

//EmployeeRepository will provide a CRUD database operations for the Employee entity.
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
