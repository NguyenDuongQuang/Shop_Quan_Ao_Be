package com.example.backend.service;
import com.example.backend.dto.EmployeeDto;
import com.example.backend.dto.UpdateProfileDto;
import com.example.backend.entity.Employee;
import com.example.backend.model.EmployeeSearchCriteriaModel;
import org.springframework.data.domain.Page;

public interface EmployeeService {
    Employee getEmployee(String username);
    Employee getEmployee(Long id);
    Employee createEmployee(EmployeeDto employee) throws Exception;
    Employee updateEmployee(EmployeeDto employee, Long id);
    Employee updateProfile(UpdateProfileDto employee, Long id);
    Page<Employee> getEmployees(EmployeeSearchCriteriaModel employeeSearchCriteria);
}
